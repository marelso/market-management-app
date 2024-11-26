package io.marelso.marketmanagement.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun AppNavigationGraph(navHostController: NavHostController = rememberNavController()) {
    NavHost(navController = navHostController, startDestination = Routes.OnBoarding.route) {
        composable(route = Routes.OnBoarding.route) {

        }

        composable(route = Routes.Registration.route) {

        }

        composable(route = Routes.Home.route) {

        }
    }
}