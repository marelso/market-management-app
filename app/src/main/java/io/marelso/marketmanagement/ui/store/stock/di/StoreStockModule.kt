package io.marelso.marketmanagement.ui.store.stock.di

import io.marelso.marketmanagement.ui.store.stock.StoreStockViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val storeStockModule = module {
    viewModelOf(::StoreStockViewModel)
}