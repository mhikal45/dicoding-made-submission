package com.wal.winteranimelist2021

import android.app.Application
import com.wal.winteranimelist2021.core.di.databaseModule
import com.wal.winteranimelist2021.core.di.networkModule
import com.wal.winteranimelist2021.core.di.repositoryModule
import com.wal.winteranimelist2021.di.useCaseModule
import com.wal.winteranimelist2021.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}