package com.db.post.postbook.base

import com.db.post.postbook.restServices.UserPost

interface OnPostClickListener {
    fun onPostClick(post: UserPost)
}