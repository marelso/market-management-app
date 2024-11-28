package io.marelso.marketmanagement.data.network.account

import io.marelso.marketmanagement.data.AccountCreate

class AccountRemoteDataSource(private val service: AccountService) {
    suspend fun authenticate(email: String, password: String) = service.authenticate(email, password)
    suspend fun create(request: AccountCreate) = service.create(request)
}