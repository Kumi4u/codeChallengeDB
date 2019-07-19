package com.db.post.postbook.base

import com.db.post.postbook.restServices.UserPost

interface OnUserPostClickListener {
    fun onPostClick(post: UserPost)
}