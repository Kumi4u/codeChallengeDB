package com.db.post.postbook.base

import android.app.Application
import com.db.post.postbook.di.userModule
import org.koin.core.context.startKoin

class PostBookApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(listOf(userModule))
        }
    }
}