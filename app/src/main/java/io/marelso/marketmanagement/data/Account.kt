package io.marelso.marketmanagement.data

data class Account(
    val reference: String? = null,
    val firstName: String,
    val lastName: String,
    val email: String,
    val pictureUrl: String? = null,
    val context: List<StorePermission>,
    val jwt: String? = null,
)
