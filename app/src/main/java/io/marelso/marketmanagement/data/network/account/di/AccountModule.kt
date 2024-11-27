package io.marelso.marketmanagement.data.network.account.di

import io.marelso.marketmanagement.data.Constant
import io.marelso.marketmanagement.data.network.account.AccountRemoteDataSource
import io.marelso.marketmanagement.data.network.account.AccountRepository
import io.marelso.marketmanagement.data.network.account.AccountService
import org.koin.core.module.dsl.factoryOf
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val accountModule = module {
    factory {
        get<Retrofit>(named(Constant.MARKET_API.NAME)).create(AccountService::class.java)
    }
    factoryOf(::AccountRemoteDataSource)
    factoryOf(::AccountRepository)
}