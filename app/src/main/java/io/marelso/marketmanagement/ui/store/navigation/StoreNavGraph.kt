package io.marelso.marketmanagement.ui.store.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.marelso.marketmanagement.data.navigate
import io.marelso.marketmanagement.navigation.Routes
import io.marelso.marketmanagement.ui.store.home.StoreHomeScreenHoisting
import io.marelso.marketmanagement.ui.store.product.ProductScreenHoisting
import io.marelso.marketmanagement.ui.store.stock.StoreStockScreenHoisting
import org.koin.androidx.compose.koinViewModel

@Composable
fun StoreNavGraph(
    navHostController: NavHostController = rememberNavController()
) {
    NavHost(navController = navHostController, startDestination = StoreRoutes.Home.route) {
        composable(route = StoreRoutes.Home.route) { StoreHomeScreenHoisting() }

        composable(route = StoreRoutes.Stock.route) {
            StoreStockScreenHoisting(koinViewModel()) {
                navHostController.navigate(
                    StoreRoutes.Stock.navigate(Routes.Store, ARG_PRODUCT_ID to it)
                )
            }
        }

        composable(route = StoreRoutes.Stock.route) { ProductScreenHoisting() }

        composable(route = StoreRoutes.Entries.route) { Text(text = "Entries") }

        composable(route = StoreRoutes.Settings.route) { Text(text = "Settings") }
    }
}