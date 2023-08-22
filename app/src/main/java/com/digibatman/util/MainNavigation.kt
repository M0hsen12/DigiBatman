package com.digibatman.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.digibatman.ui.details.DetailScreen
import com.digibatman.ui.home.HomeScreen


sealed class Screens(val route: String) {
    object Home : Screens("home")
    object Details : Screens("details")


}


@Composable
fun MainNavigation(
    navController: NavHostController = rememberNavController(),
) {


    NavHost(
        navController = navController,
        startDestination = Screens.Home.route,
        modifier = Modifier
    ) {
        composable(Screens.Home.route) {
            HomeScreen(navController)
        }
        composable(Screens.Details.route) {
            DetailScreen(navController)
        }


    }
}

