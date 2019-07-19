package com.db.post.postbook.model

import com.db.post.postbook.restServices.User
import io.reactivex.Single
import javax.inject.Inject

class UserModel {

    @Inject
    lateinit var postBookRestService: PostBookRestService

    init {
        PostBookApplication.getPostBookApplication().userComponent.inject(this)
    }

    fun getUserPostBookInformation(userId: String): Single<User> {

        return postBookRestService.getUserInfo(userId)

    }
}