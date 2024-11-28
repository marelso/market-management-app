package io.marelso.marketmanagement.ui.stores.di

import io.marelso.marketmanagement.ui.stores.StoresViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val storesModule = module {
    viewModelOf(::StoresViewModel)
}