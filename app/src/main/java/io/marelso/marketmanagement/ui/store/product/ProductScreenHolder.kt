package io.marelso.marketmanagement.ui.store.product

import androidx.compose.foundation.ScrollState
import io.marelso.marketmanagement.data.Product

data class ProductScreenHolder(
    val product: Product?,
    val isLoading: Boolean,
    val hasError: Boolean,
    val scrollState: ScrollState,
    val onEditClick: () -> Unit,
    val onDeleteClick: () -> Unit,
    val onNavBack: () -> Unit
)
