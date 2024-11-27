package io.marelso.marketmanagement.data

data class Address(
    var street: String,
    val number: String,
    val neighborhood: String,
    val city: String,
    val state: String,
    val country: Country,
    val plusCode: String? = null
)
