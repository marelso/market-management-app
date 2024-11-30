package io.marelso.marketmanagement.ui.store.product

import io.marelso.marketmanagement.data.Product

data class ProductScreenHolder(
    val product: Product,
    val onEditClick: (String) -> Unit,
    val onNavBack: () -> Unit
)
