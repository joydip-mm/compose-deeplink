package com.example.deeplink_compose_app.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry

@Composable
fun DetailsScreen(entry: NavBackStackEntry){
    val name = entry.arguments?.getString("name")
    val age = entry.arguments?.getInt("age")
    Column(Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Hi,I am ${name} and I am ${age} years old")
    }
}