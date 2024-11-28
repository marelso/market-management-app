package io.marelso.marketmanagement.data.di

import io.marelso.marketmanagement.data.Account
import io.marelso.marketmanagement.data.Constant.CURRENT_ACCOUNT
import io.marelso.marketmanagement.data.Session
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {
    factory<Account>(named(CURRENT_ACCOUNT)) { provideAccount() }
}

private fun provideAccount(): Account {
    return Session.account
}