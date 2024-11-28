package io.marelso.marketmanagement.data

data class AccountCreate(
    val firstName: String,
    val lastName: String,
    val pictureUrl: String? = null,
    val email: String,
    val password: String
)
