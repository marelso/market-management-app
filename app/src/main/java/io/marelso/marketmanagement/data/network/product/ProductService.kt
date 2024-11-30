package io.marelso.marketmanagement.data.network.product

import io.marelso.marketmanagement.data.CreateProductDto
import io.marelso.marketmanagement.data.Page
import io.marelso.marketmanagement.data.Product
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductService {
    @GET("/api/v1/products")
    suspend fun getProductsByStoreId(
        @Query("storeId") storeId: String,
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Response<Page<Product>>

    @GET("/api/v1/products/{id}")
    suspend fun getProductsById(@Path("id") id: String, ): Response<Product>

    @POST("/api/v1/products")
    suspend fun createProduct(
        @Body request: CreateProductDto
    ): Response<Product>
}