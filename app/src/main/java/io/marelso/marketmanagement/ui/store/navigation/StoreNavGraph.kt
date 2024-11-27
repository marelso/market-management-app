package io.marelso.marketmanagement.ui.store.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun StoreNavGraph(
    navHostController: NavHostController = rememberNavController()
) {
    NavHost(navController = navHostController, startDestination = StoreRoutes.Home.route) {
        composable(route = StoreRoutes.Home.route) { Text(text = "Home") }

        composable(route = StoreRoutes.Stock.route) { Text(text = "Stock") }

        composable(route = StoreRoutes.Entries.route) { Text(text = "Entries") }

        composable(route = StoreRoutes.Settings.route) { Text(text = "Settings") }
    }
}