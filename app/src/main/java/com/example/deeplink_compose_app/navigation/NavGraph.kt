package com.example.deeplink_compose_app.navigation

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.deeplink_compose_app.NavigationDeepLinks.FIRST_SCREEN_DEEPLINK
import com.example.deeplink_compose_app.NavigationDeepLinks.SECOND_SCREEN_DEEPLINK
import com.example.deeplink_compose_app.screens.SecondScreen
import com.example.deeplink_compose_app.screens.FirstScreen

@Composable
fun setNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.FirstScreen.route){
        composable(
            route = Screen.FirstScreen.route,
            deepLinks = listOf(
                navDeepLink {
                    uriPattern = FIRST_SCREEN_DEEPLINK
                    action = Intent.ACTION_VIEW
                }
            ),
            arguments = listOf(
                navArgument("app_name"){
                    type = NavType.StringType
                    defaultValue = "Default Screen With No Argument"
                }

            )
        ){entry->
            FirstScreen(entry)
        }

        composable(
            route = Screen.DetailScreen.route,
            deepLinks = listOf(
                navDeepLink {
                    uriPattern = SECOND_SCREEN_DEEPLINK
                    action = Intent.ACTION_VIEW
                }
            ),
            arguments = listOf(
                navArgument("name"){
                    type = NavType.StringType
                    defaultValue = "Default Name"
                },
                navArgument("age"){
                    type = NavType.IntType
                    defaultValue = 0
                }

            )
        ){entry->
            SecondScreen(entry)
        }
    }
}