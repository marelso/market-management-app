package io.marelso.marketmanagement.ui.store.stock

import androidx.paging.compose.LazyPagingItems
import io.marelso.marketmanagement.data.Product

data class StoreStockScreenHolder(
    val products: LazyPagingItems<Product>,
    val isSheetVisible: Boolean,
    val query: String,
    val name: String,
    val price: Double,
    val onProductClick: (String) -> Unit,
    val onQueryChange: (String) -> Unit,
    val onNameChange: (String) -> Unit,
    val onPriceChange: (String) -> Unit,
    val onSheetVisibilityChange: (Boolean) -> Unit,
    val onSubmit: () -> Unit
)