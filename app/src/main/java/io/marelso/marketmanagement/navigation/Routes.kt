package io.marelso.marketmanagement.navigation

import io.marelso.marketmanagement.data.Route

const val ARG_STORE_ID = "storeId"

sealed class Routes(override val route: String): Route(route) {
    data object OnBoarding: Routes(route = "/onboarding")
    data object SignIn: Routes(route = "/sign-in")
    data object SignUp: Routes(route = "/sign-up")
    data object Stores: Routes(route = "/stores")
    data object Store: Routes(route = "/stores/{$ARG_STORE_ID}")
    data object Buy: Routes(route = "/stores/{$ARG_STORE_ID}/buy")
    data object Sell: Routes(route = "/stores/{$ARG_STORE_ID}/sell")
}