package com.example.basiccomposeloginapp.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basiccomposeloginapp.network.model.LoginDto
import com.example.basiccomposeloginapp.repository.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel:ViewModel() {

    val isSuccessLoading = mutableStateOf(false)

    val progressBar = mutableStateOf(value = false)

    fun login(email: String, password: String) {

        viewModelScope.launch(Dispatchers.IO) {

            try {

                progressBar.value = true
                val authService = RetrofitHelper.getAuthService()
                val responseService =
                    withContext(viewModelScope.coroutineContext) {
                        authService.getLogin(
                            LoginDto(
                                email = email,
                                password = password.trim().toString()
                            )
                        )

                    }


                if (responseService.isSuccessful) {
//                    delay(1500L)
                    isSuccessLoading.value = true

                    progressBar.value = false
                    responseService.body()?.let { tokenDto ->
                        Log.d("Logging", "Response TokenDto: $tokenDto")
                    }
                } else {

                    progressBar.value = false

                    responseService.errorBody()?.let { error ->
//                        imageErrorAuth.value = true
//                        delay(1500L)
//                        imageErrorAuth.value = false
                        Log.d("Logging", "Response Error")
                        error.close()
                    }
                }

            }
            catch (e:Exception){

            }

        }


    }
}