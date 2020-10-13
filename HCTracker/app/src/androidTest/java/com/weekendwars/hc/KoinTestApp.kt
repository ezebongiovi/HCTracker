package com.weekendwars.hc

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class KoinTestApp: Application() {

    private lateinit var koin: KoinApplication

    override fun onCreate() {
        super.onCreate()

        koin = startKoin {
            androidContext(this@KoinTestApp)
        }
    }

    fun setUpModule(module: Module) {
        koin.modules(module).createEagerInstances()
    }

    fun closeKoin() {
        koin.close()
    }
}