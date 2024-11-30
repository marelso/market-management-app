package io.marelso.marketmanagement.ui.store.product

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.marelso.marketmanagement.ui.components.AppTopBar
import io.marelso.marketmanagement.ui.components.TopBarAction

@Composable
fun ProductScreenHoisting(
    viewModel: ProductViewModel, onNavBack: () -> Unit
) {
    val scrollState = rememberScrollState()
    val product by viewModel.product.collectAsStateWithLifecycle()
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    ProductScreen(
        holder = ProductScreenHolder(
            product = product,
            isLoading = state is ProductUiState.LOADING,
            hasError = state is ProductUiState.ERROR,
            scrollState = scrollState,
            onEditClick = {},
            onDeleteClick = {},
            onNavBack = onNavBack,
        )
    )
}

@Composable
private fun ProductScreen(modifier: Modifier = Modifier, holder: ProductScreenHolder) {
    Scaffold(topBar = {
        AppTopBar(
            title = "Detalhes",
            actions = listOf(
                TopBarAction(
                    icon = Icons.Default.Edit,
                    isActive = holder.isLoading.not() && holder.hasError.not(),
                    onActionClick = holder.onEditClick,
                ), TopBarAction(
                    icon = Icons.Default.Delete,
                    isActive = holder.isLoading.not() && holder.hasError.not(),
                    onActionClick = holder.onDeleteClick,
                )
            ),
            onNavigationClick = holder.onNavBack
        )
    }) {
        Column(
            modifier
                .padding(it)
                .padding(horizontal = 16.dp)
                .verticalScroll(holder.scrollState),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            when {
                holder.isLoading -> {}
                holder.hasError -> {}
                else -> {

                }
            }
        }
    }
}