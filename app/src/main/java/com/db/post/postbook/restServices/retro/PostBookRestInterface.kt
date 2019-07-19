package com.db.post.postbook.restServices.retro

import com.db.post.postbook.restServices.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface PostBookRestInterface {


    @GET("userList")
    fun getUserData(
        @Query("id") userId: String
    ): Single<User>

}