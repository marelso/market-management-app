package io.marelso.marketmanagement.ui.signin.di

import io.marelso.marketmanagement.ui.signin.SignInViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val signInModule = module {
    viewModelOf(::SignInViewModel)
}