package io.marelso.marketmanagement.data.network.di

import com.google.gson.GsonBuilder
import io.marelso.marketmanagement.data.Account
import io.marelso.marketmanagement.data.Constant
import io.marelso.marketmanagement.data.Session
import io.marelso.marketmanagement.data.network.account.di.accountModule
import io.marelso.marketmanagement.data.network.product.di.productModule
import io.marelso.marketmanagement.data.network.store.di.storeModule
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    factory(named(Constant.MARKET_API.NAME)) {
        Retrofit.Builder().client(OkHttpClient.Builder().apply {
            connectTimeout(3, TimeUnit.MINUTES)
            writeTimeout(3, TimeUnit.MINUTES)
            readTimeout(3, TimeUnit.MINUTES)

            addInterceptor { chain ->
                chain.proceed(
                    chain.request().newBuilder().apply {
                        addHeader("Connection", "Keep-Alive")
                        addHeader("Accept", "application/json")
                        addHeader("Content-Type", "application/json")

                        if(Session.isAccountInitialized()) {
                            addHeader("Authorization", "Bearer ${Session.account.jwt.orEmpty()}")
                        }
                    }.build()
                )
            }
        }.build()).baseUrl(Constant.MARKET_API.URL)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .setLenient()
                        .create()
                )
            ).build()
    }

    includes(accountModule, storeModule, productModule)
}