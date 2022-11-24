package com.example.deeplink_compose_app.navigation

sealed class Screen(val route : String = "") {
    object FirstScreen : Screen("first_screen")
    object DetailScreen : Screen("detail_screen")
    object SZero : Screen()
}