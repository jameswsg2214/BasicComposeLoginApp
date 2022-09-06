package com.example.basiccomposeloginapp.navigation

sealed class Destination(val route:String){
    object Login: Destination(route = "Login")
    object HomeScreen: Destination(route = "HomeScreen")

    companion object {

        fun startDestination() = Login.route

    }
}
