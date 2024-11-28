package io.marelso.marketmanagement.data

object Session {
    fun isAccountInitialized(): Boolean {
        return ::account.isInitialized
    }

    lateinit var account: Account
    lateinit var store: Store
}