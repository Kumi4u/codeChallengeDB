package com.db.post.postbook.base

import com.db.post.postbook.restServices.UserPost

interface OnPostFavClickListener {
    fun onFavClick(post: UserPost)
}