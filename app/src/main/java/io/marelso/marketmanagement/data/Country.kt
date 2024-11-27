package io.marelso.marketmanagement.data

enum class Country(val language: String, val code: String, currency: String) {
    BRAZIL("pt", "BR", "BRL"),
    UNITED_STATES("en", "US", "USD"),
    MEXICO("es", "MX", "MXN"),
    CANADA("en", "CA", "CAD");
}
