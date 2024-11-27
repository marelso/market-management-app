package io.marelso.marketmanagement.data.network.di

import io.marelso.marketmanagement.data.Constant
import io.marelso.marketmanagement.data.network.account.di.accountModule
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory(named(Constant.MARKET_API.NAME)) {
        Retrofit.Builder().client(OkHttpClient.Builder().apply {
            addInterceptor { chain ->
                chain.proceed(
                    chain.request().newBuilder().apply {
//                        addHeader("Authorization", Session.token.orEmpty())
//                        addHeader("storeId", get<Store>(named()).id.orEmpty())
                    }.build()
                )
            }
        }.build()).baseUrl(Constant.MARKET_API.URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    includes(accountModule)
}