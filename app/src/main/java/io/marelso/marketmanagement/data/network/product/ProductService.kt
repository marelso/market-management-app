package io.marelso.marketmanagement.data.network.product

import io.marelso.marketmanagement.data.Page
import io.marelso.marketmanagement.data.Product
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {
    @GET("/api/v1/products")
    suspend fun getProductsByStoreId(
        @Query("storeId") storeId: String,
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Response<Page<Product>>
}