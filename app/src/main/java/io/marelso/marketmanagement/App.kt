package io.marelso.marketmanagement

import android.app.Application
import io.marelso.marketmanagement.data.di.dataModule
import io.marelso.marketmanagement.data.network.di.networkModule
import io.marelso.marketmanagement.ui.signin.di.signInModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        GlobalContext.startKoin {
            androidContext(this@App)
            modules(
                dataModule,
                networkModule,
                signInModule,
            )
        }
    }
}