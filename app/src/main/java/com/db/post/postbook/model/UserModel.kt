package com.db.post.postbook.model

import com.db.post.postbook.restServices.User
import com.db.post.postbook.restServices.UserPost

class UserModel {


    lateinit var user: User
    lateinit var userPost: UserPost

    fun setCurrentUser(user: User) {
        this.user = user
    }

    fun getCurrentUser(): User {
        return this.user
    }

    fun setCurrentPost(post: UserPost) {
        this.userPost = post
    }

    fun getCurrentUserPost(): UserPost {
        return this.userPost
    }

    fun updatePostLikeness(userPost: UserPost) {
        val user = getCurrentUser()

        if (user.userPostList.contains(userPost)) {

            val iterate = user.userPostList.listIterator()
            while (iterate.hasNext()) {
                val post = iterate.next()
                if (post.postID == userPost.postID) {
                    post.isFav = !userPost.isFav
                }
            }
            setCurrentUser(user)
        }
    }

    fun getFavPosts(): List<UserPost> {
        val favPostList = ArrayList<UserPost>()

        val iterate = user.userPostList.listIterator()

        while (iterate.hasNext()) {
            val post = iterate.next()
            if (post.isFav) {
                favPostList.add(post)
            }
        }
        return favPostList
    }


}