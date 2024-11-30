package io.marelso.marketmanagement.ui.store.stock

import androidx.paging.compose.LazyPagingItems
import io.marelso.marketmanagement.data.Product

data class StoreStockScreenHolder(
    val products: LazyPagingItems<Product>,
    val query: String,
    val onQueryChange: (String) -> Unit
)