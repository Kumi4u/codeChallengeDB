package com.db.post.postbook.di

import com.db.post.postbook.restServices.retro.PostBookRestService
import org.koin.dsl.module


val userModule = module {

    single {
        PostBookRestService().createRestService()
    }

}