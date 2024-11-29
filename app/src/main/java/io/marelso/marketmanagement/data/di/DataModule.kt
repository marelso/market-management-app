package io.marelso.marketmanagement.data.di

import io.marelso.marketmanagement.data.Account
import io.marelso.marketmanagement.data.Constant.CURRENT_ACCOUNT
import io.marelso.marketmanagement.data.Constant.CURRENT_STORE
import io.marelso.marketmanagement.data.Session
import io.marelso.marketmanagement.data.Store
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {
    factory<Account> { provideAccount() }
    factory<Account>(named(CURRENT_ACCOUNT)) { provideAccount() }
    factory<Store> { provideStore() }
    factory<Store>(named(CURRENT_STORE)) { provideStore() }
}

private fun provideAccount(): Account {
    return Session.account
}

private fun provideStore(): Store {
    return Session.store
}