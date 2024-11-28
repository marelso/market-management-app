package io.marelso.marketmanagement.data.network.store

class StoreRemoteDataSource(private val service: StoreService) {
    suspend fun getUserStores() = service.getUserStores()
}