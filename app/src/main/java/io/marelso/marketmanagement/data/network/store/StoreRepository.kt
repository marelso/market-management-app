package io.marelso.marketmanagement.data.network.store

class StoreRepository(private val dataSource: StoreRemoteDataSource) {
    suspend fun getUserStores() = dataSource.getUserStores()
}