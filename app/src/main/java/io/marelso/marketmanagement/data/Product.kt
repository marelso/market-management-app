package io.marelso.marketmanagement.data

data class Product(
    val id: String,
    val pictureUrl: String? = null,
    val description: String? = null,
    val count: Int = 0,
    val name: String,
    val price: Double,
    val storeId: String,
)