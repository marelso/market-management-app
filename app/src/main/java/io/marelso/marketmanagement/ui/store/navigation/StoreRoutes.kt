package io.marelso.marketmanagement.ui.store.navigation

import io.marelso.marketmanagement.R
import io.marelso.marketmanagement.data.Route

val ARG_PRODUCT_ID = "productId"

sealed class StoreRoutes(
    override val route: String,
    val icon: Int,
    onAction: () -> Unit = {}
): Route(route) {
    data object Home : StoreRoutes(route = "/home", icon = R.drawable.ic_home)
    data object Stock : StoreRoutes(route = "/stock", icon = R.drawable.ic_stock)
    data object Product : StoreRoutes(route = "/product/{$ARG_PRODUCT_ID}", icon = R.drawable.ic_stock)
    data object Entries : StoreRoutes(route = "/entries", icon = R.drawable.ic_entries)
    data object Settings : StoreRoutes(route = "/settings", icon = R.drawable.ic_notifications)
}