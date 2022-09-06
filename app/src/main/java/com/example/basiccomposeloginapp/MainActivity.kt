package com.example.basiccomposeloginapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass.Companion.Compact
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass.Companion.Expanded
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass.Companion.Medium
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.basiccomposeloginapp.navigation.NavigationScreen
import com.example.basiccomposeloginapp.ui.homeScreen.HomeScreen
import com.example.basiccomposeloginapp.ui.theme.BasicComposeLoginAppTheme
import com.example.basiccomposeloginapp.viewModel.LoginViewModel

@ExperimentalMaterial3WindowSizeClassApi
class MainActivity : ComponentActivity() {

    private val loginViewModel:LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

/*
        {
            "email":"santiago@mail.com",
            "password":"passw0rd"
        }

        */
        setContent {
            BasicComposeLoginAppTheme {
                // A surface container using the 'background' color from the theme

                val windowSize = calculateWindowSizeClass(this)

                when(windowSize.widthSizeClass){

                    Compact->{
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colors.background
                        ) {
//                    Greeting("Android")
                            NavigationScreen(loginViewModel)
                        }
                    }
                    Medium->{

                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colors.background
                        ) {
                            HomeScreen("medium")
                        }
                    }
                    Expanded->{
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colors.background
                        ) {
                            HomeScreen("Expanded")
                        }
                    }
                    else->{

                    }

                }

            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BasicComposeLoginAppTheme {
        Greeting("Android")
    }
}