package com.example.desafiodimensa

import android.app.Application
import com.example.desafiodimensa.di.appModule
import com.example.desafiodimensa.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin


class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppApplication)
            modules(appModule, networkModule) // Certifique-se de que o módulo está sendo carregado
        }
    }
}
