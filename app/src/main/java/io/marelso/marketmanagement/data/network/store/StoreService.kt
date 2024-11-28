package io.marelso.marketmanagement.data.network.store

import io.marelso.marketmanagement.data.Store
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface StoreService {
    @GET("/api/v1/stores")
    suspend fun getUserStores(): Response<List<Store>>

    @GET("/api/v1/stores/{id}")
    suspend fun getStoreById(
        @Path("id") id: String
    )

    @POST("/api/v1/stores")
    suspend fun createStore(
        @Query("query") query: String
    )
}