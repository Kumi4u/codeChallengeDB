package com.db.post.postbook.restServices.retro

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class PostBookRestService {


    val baseUrl = "https://my-json-server.typicode.com/Kumi4u/codeChallengeDB/"


     fun createRestService(): PostBookRestInterface {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(getOkHttpClientWithLoggingInterceptor())
            .build()
            .create(PostBookRestInterface::class.java)
    }

    private fun getOkHttpClientWithLoggingInterceptor(): OkHttpClient {

        val builder = OkHttpClient.Builder()

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        builder.addInterceptor(httpLoggingInterceptor)
        return builder.build()
    }

}