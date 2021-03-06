package com.example.chucknorris

import android.app.Application
import com.example.chucknorris.database.database
import com.example.chucknorris.jokes.jokes
import com.example.chucknorris.main.main
import com.example.chucknorris.network.retrofit
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class NorrisApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@NorrisApplication)
            modules(
                database,
                retrofit,
                jokes,
                main
            )
        }
    }
}