package io.marelso.marketmanagement.data

data class CreateProductDto(
    val storeId: String? = null,
    val name: String,
    val price: Double,
    val pictureUrl: String? = null,
    val description: String? = null
)
