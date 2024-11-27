package io.marelso.marketmanagement.data.network.account

class AccountRepository(private val dataSource: AccountRemoteDataSource) {
    suspend fun authenticate(email: String, password: String) = dataSource.authenticate(email, password)
}