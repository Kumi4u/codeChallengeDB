package com.db.post.postbook.model

import com.db.post.postbook.restServices.User

class UserModel() {


    lateinit var user: User


    fun setCurrentUser(  user: User){
     this.user = user
    }

    fun getCurrentUser():User{
        return this.user
    }



}