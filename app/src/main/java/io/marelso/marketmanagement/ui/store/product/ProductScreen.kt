package io.marelso.marketmanagement.ui.store.product

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import io.marelso.marketmanagement.ui.components.AppTopBar
import io.marelso.marketmanagement.ui.components.TopBarAction

@Composable
fun ProductScreenHoisting(
    viewM
    onNavBack: () -> Unit
) {
    ProductScreen(
        holder = ProductScreenHolder(
            product = ,
            onEditClick = ,
            onNavBack = ,
        )
    )
}

@Composable
private fun ProductScreen(holder: ProductScreenHolder) {
    Scaffold(topBar = {
        AppTopBar(
            actions = listOf(
                TopBarAction(
                    icon = Icons.Default.Edit,
                    isActive = true,
                    onActionClick = holder.onEditClick,
                )
            )
        ) {
            holder.onNavBack()
        }
    }) {

    }
}