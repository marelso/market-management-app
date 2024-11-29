package io.marelso.marketmanagement.ui.store.di

import io.marelso.marketmanagement.ui.store.stock.di.storeStockModule
import org.koin.dsl.module

val storeModule = module {
    includes(storeStockModule)
}