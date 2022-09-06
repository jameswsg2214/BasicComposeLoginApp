package com.example.basiccomposeloginapp.ui.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basiccomposeloginapp.ui.login.components.ProgressBarLoading
import com.example.basiccomposeloginapp.ui.theme.BasicComposeLoginAppTheme
import com.example.basiccomposeloginapp.viewModel.LoginViewModel


@Composable
fun LoginScreen(login: (String, String) -> Unit, isLoading: Boolean, viewModel: LoginViewModel) {

    var emailId by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var response by rememberSaveable { mutableStateOf("") }

    var loading = viewModel.progressBar.value

    Column(
        modifier =
            Modifier
                .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Login",
            modifier =
                Modifier
                    .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.padding(5.dp))
/*        Text(
            text = "Username",
            modifier =
            Modifier
                .fillMaxWidth()
                .padding(start = 5.dp, end = 5.dp)
        )*/
        OutlinedTextField(
            value = emailId,
            onValueChange = { emailId= it},
            singleLine = true,
            keyboardOptions =
            KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            modifier =
            Modifier
                .fillMaxWidth()
                .padding(start = 5.dp, end = 5.dp),
            label = { Text(text = "Email")}
        )

        Spacer(modifier = Modifier.padding(5.dp))

        OutlinedTextField(
            value = password ,
            onValueChange = { password= it },
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp),
            keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
            label = { Text(text = "Password")},
            singleLine = true
        )

        Spacer(modifier = Modifier.padding(5.dp))
        
        Button(
            onClick = {
//                          login(emailId,password)
                viewModel.login(emailId,password)

                      },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Login")
            
        }

        ClickableText(
            text = AnnotatedString(text = "SignUp"),
            onClick = {},
            modifier =
            Modifier
                .align(Alignment.End)
        )

    }

    ProgressBarLoading(isLoading = loading)

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BasicComposeLoginAppTheme() {

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
       /*     LoginScreen(login = { email, password->
            }, isLoading = false,)*/
        }

    }
}

