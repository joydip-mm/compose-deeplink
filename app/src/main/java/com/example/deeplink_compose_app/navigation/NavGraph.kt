package com.example.deeplink_compose_app.navigation

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.deeplink_compose_app.screens.DetailsScreen
import com.example.deeplink_compose_app.screens.FirstScreen

@Composable
fun setNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.FirstScreen.route){
        composable(
            route = Screen.FirstScreen.route,
            deepLinks = listOf(
                navDeepLink {
                    uriPattern = "https://myapp.com/first_screen/{app_name}"
                    action = Intent.ACTION_VIEW
                }
            ),
            arguments = listOf(
                navArgument("app_name"){
                    type = NavType.StringType
                    defaultValue = ""
                }

            )
        ){entry->
            FirstScreen(entry)
        }

        composable(
            route = Screen.DetailScreen.route,
            deepLinks = listOf(
                navDeepLink {
                    uriPattern = "https://myapp.com/user_details/{name}?age={age}"
                    action = Intent.ACTION_VIEW
                }
            ),
            arguments = listOf(
                navArgument("name"){
                    type = NavType.StringType
                    defaultValue = ""
                },
                navArgument("age"){
                    type = NavType.IntType
                    defaultValue = 0
                }

            )
        ){entry->
            DetailsScreen(entry)
        }
    }
}