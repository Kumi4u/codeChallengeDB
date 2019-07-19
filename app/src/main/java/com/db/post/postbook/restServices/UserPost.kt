package com.db.post.postbook.restServices

data class UserPost(

    val postID: String,
    val postTitle: String,
    val postText: String,
    var isFav: Boolean,
    val userCommentList: List<UserComment>
)
