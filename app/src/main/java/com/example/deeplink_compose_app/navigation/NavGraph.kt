package com.example.deeplink_compose_app.navigation

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import com.example.deeplink_compose_app.screens.DetailsScreen
import com.example.deeplink_compose_app.screens.FirstScreen

@Composable
fun setNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.FirstScreen.route){
        composable(
            route = Screen.FirstScreen.route,
            deepLinks = listOf(
                navDeepLink {
                    uriPattern = "https://myapp.com/first_screen"
                    action = Intent.ACTION_VIEW
                }
            )
        ){
            FirstScreen()
        }
        composable(
            route = Screen.DetailScreen.route,
            deepLinks = listOf(
                navDeepLink {
                    uriPattern = "https://myapp.com/details_screen"
                    action = Intent.ACTION_VIEW
                }
            )
        ){
            DetailsScreen()
        }
    }
}