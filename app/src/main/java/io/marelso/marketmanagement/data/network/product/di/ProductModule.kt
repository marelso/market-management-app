package io.marelso.marketmanagement.data.network.product.di

import io.marelso.marketmanagement.data.Constant
import io.marelso.marketmanagement.data.network.product.ProductRemoteDataSource
import io.marelso.marketmanagement.data.network.product.ProductRepository
import io.marelso.marketmanagement.data.network.product.ProductService
import org.koin.core.module.dsl.factoryOf
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val productModule = module {
    factory {
        get<Retrofit>(named(Constant.MARKET_API.NAME)).create(ProductService::class.java)
    }
    factoryOf(::ProductRemoteDataSource)
    factoryOf(::ProductRepository)
}