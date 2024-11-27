package io.marelso.marketmanagement.data.network.account

class AccountRemoteDataSource(private val service: AccountService) {
    suspend fun authenticate(email: String, password: String) = service.authenticate(email, password)
}