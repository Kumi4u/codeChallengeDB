package com.db.post.postbook.restServices

import java.io.Serializable

data class User(

    val id: String,
    val userName: String,
    val userPostList: List<UserPost>
):Serializable
