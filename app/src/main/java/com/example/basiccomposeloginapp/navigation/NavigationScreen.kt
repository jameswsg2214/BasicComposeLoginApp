package com.example.basiccomposeloginapp.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.basiccomposeloginapp.navigation.Destination.Companion.startDestination
import com.example.basiccomposeloginapp.ui.homeScreen.HomeScreen
import com.example.basiccomposeloginapp.ui.login.LoginScreen
import com.example.basiccomposeloginapp.viewModel.LoginViewModel


@Composable
fun NavigationScreen(viewModel: LoginViewModel){

    val navController = rememberNavController()
    val processBar = viewModel.progressBar.value
    NavHost(navController = navController, startDestination = startDestination()){

        composable(route = Destination.Login.route){

            if (viewModel.isSuccessLoading.value) {
                LaunchedEffect(key1 = Unit) {
                    navController.navigate(route = Destination.HomeScreen.route) {
                        popUpTo(route = Destination.Login.route) {
                            inclusive = true
                        }
                    }
                }
            } else {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    LoginScreen(login = viewModel::login, isLoading =processBar,viewModel=viewModel)
                }

            }

        }

        composable(route = Destination.HomeScreen.route){

            HomeScreen("Welcome")
        }

    }


}