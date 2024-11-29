package io.marelso.marketmanagement.data

data class Page<T>(
    val content: List<T>,
    val totalElements: Long,
    val last: Boolean
)
