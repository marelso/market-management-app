package io.marelso.marketmanagement.data

data class Store(
    val id: String,
    val name: String,
    val pictureUrl: String? = null,
    val description: String? = null,
    val address: Address? = null,
)