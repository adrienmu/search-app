package com.amussio.myfirstapp

import android.app.Application
import com.amussio.myfirstapp.domain.di.appModule
import com.amussio.myfirstapp.domain.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@MyApplication)
            modules(appModule)
            modules(networkModule)
        }
    }
}