package io.marelso.marketmanagement.data.network.account

import io.marelso.marketmanagement.data.AccountCreate

class AccountRepository(private val dataSource: AccountRemoteDataSource) {
    suspend fun authenticate(email: String, password: String) = dataSource.authenticate(email, password)
    suspend fun create(request: AccountCreate) = dataSource.create(request)
}