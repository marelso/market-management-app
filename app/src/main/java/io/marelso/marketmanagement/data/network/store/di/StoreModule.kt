package io.marelso.marketmanagement.data.network.store.di

import io.marelso.marketmanagement.data.Constant
import io.marelso.marketmanagement.data.network.store.StoreRemoteDataSource
import io.marelso.marketmanagement.data.network.store.StoreRepository
import io.marelso.marketmanagement.data.network.store.StoreService
import org.koin.core.module.dsl.factoryOf
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val storeModule = module {
    factory {
        get<Retrofit>(named(Constant.MARKET_API.NAME)).create(StoreService::class.java)
    }
    factoryOf(::StoreRemoteDataSource)
    factoryOf(::StoreRepository)
}