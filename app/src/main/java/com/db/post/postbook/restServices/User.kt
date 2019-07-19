package com.db.post.postbook.restServices

data class User(

    val id: String,
    val userName: String,
    val userPostList: List<UserPost>
)
