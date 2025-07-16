package br.com.renancsdev.sky.presentation.di

import android.app.Application
import br.com.renancsdev.sky.R
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            properties(mapOf("api_key" to getString(R.string.api_key)))
            modules(appModule)
        }
    }
}