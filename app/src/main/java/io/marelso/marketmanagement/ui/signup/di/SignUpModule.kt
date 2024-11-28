package io.marelso.marketmanagement.ui.signup.di

import io.marelso.marketmanagement.ui.signup.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val signUpModule = module {
    viewModelOf(::SignUpViewModel)
}