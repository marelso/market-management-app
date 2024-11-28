package io.marelso.marketmanagement.data.network.account

import io.marelso.marketmanagement.data.Account
import io.marelso.marketmanagement.data.AccountCreate
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface AccountService {
    @POST("/api/v1/auth")
    suspend fun authenticate(
        @Query("email") email: String,
        @Query("password") password: String
    ): Response<Account>

    @POST("/api/v1/accounts")
    suspend fun create(
        @Body account: AccountCreate
    ): Response<Account>
}