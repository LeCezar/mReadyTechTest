package com.lecezar.hotelupgrade.application

import android.app.Application
import org.koin.core.context.startKoin

class MReadyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(KoinModules.modules)
        }
    }
}