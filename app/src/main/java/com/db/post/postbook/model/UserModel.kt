package com.db.post.postbook.model

import com.db.post.postbook.restServices.User
import com.db.post.postbook.restServices.UserPost

class UserModel() {


    lateinit var user: User


    fun setCurrentUser(user: User) {
        this.user = user
    }

    fun getCurrentUser(): User {
        return this.user
    }

    fun updatePostLikeness(userPost: UserPost) {
        val user = getCurrentUser()

        if (user.userPostList.contains(userPost)) {

            val iterate = user.userPostList.listIterator()
            while (iterate.hasNext()) {
                val post = iterate.next()
                if (post.postID.equals(userPost.postID)){
                    post.isFav = !userPost.isFav
                }
            }
            setCurrentUser(user)
        }
    }


}