package io.marelso.marketmanagement.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import io.marelso.marketmanagement.data.navigate
import io.marelso.marketmanagement.ui.buy.BuyScreenHoisting
import io.marelso.marketmanagement.ui.onboarding.OnBoardingScreenHoisting
import io.marelso.marketmanagement.ui.sell.SellScreenHoisting
import io.marelso.marketmanagement.ui.signin.SignInScreenHoisting
import io.marelso.marketmanagement.ui.signin.SignInViewModel
import io.marelso.marketmanagement.ui.signup.SignUpScreenHoisting
import io.marelso.marketmanagement.ui.store.StoreWorkSpaceHoisting
import io.marelso.marketmanagement.ui.stores.StoresScreenHoisting
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf


@Composable
fun AppNavigationGraph(navHostController: NavHostController = rememberNavController()) {
    NavHost(navController = navHostController, startDestination = Routes.OnBoarding.route) {
        composable(route = Routes.OnBoarding.route) {
            OnBoardingScreenHoisting(
                onSignInClick = { navHostController.navigate(Routes.OnBoarding.navigate(Routes.SignIn)) },
                onSignUpClick = { navHostController.navigate(Routes.OnBoarding.navigate(Routes.SignUp)) }
            )
        }

        composable(route = Routes.SignIn.route) {
            SignInScreenHoisting(
                viewModel = koinViewModel<SignInViewModel>(parameters = {
                    parametersOf({
                        navHostController.navigate(Routes.SignIn.navigate(Routes.Stores)) {
                            popUpTo(route = Routes.OnBoarding.route) {
                                inclusive = false
                            }
                        }
                    })
                })
            )
        }

        composable(route = Routes.SignUp.route) {
            SignUpScreenHoisting(
                viewModel = koinViewModel(parameters = {
                    parametersOf({
                        navHostController.navigate(Routes.SignIn.navigate(Routes.SignIn)) {
                            popUpTo(route = Routes.OnBoarding.route) {
                                inclusive = false
                            }
                        }
                    })
                })
            )
        }

        composable(route = Routes.Stores.route) {
            StoresScreenHoisting(
                viewModel = koinViewModel(parameters = {
                    parametersOf({
                        navHostController.navigate(
                            Routes.Stores.navigate(
                                Routes.Store,
                                ARG_STORE_ID to it.id
                            )
                        )
                    })
                })
            )
        }

        composable(
            route = Routes.Store.route,
            arguments = listOf(navArgument(ARG_STORE_ID) { NavType.StringType })
        ) { entry ->
            val storeId: String = entry.arguments?.getString(ARG_STORE_ID).orEmpty()

            StoreWorkSpaceHoisting {
                navHostController.navigate(Routes.Store.navigate(it))
            }
        }

        composable(route = Routes.Buy.route) {
            BuyScreenHoisting(onNavClick = navHostController::popBackStack)
        }

        composable(route = Routes.Sell.route) {
            SellScreenHoisting()
        }
    }
}