package com.db.post.postbook.restServices.retro

import com.db.post.postbook.restServices.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface PostBookRestInterface {


    @GET("userList/{userId}")
    fun getUserData(

        @Path("userId") userId: String
    ): Single<User>

}