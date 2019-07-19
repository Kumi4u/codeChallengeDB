package com.db.post.postbook.screen.comments

import com.db.post.postbook.base.BaseViewModel
import com.db.post.postbook.model.UserModel
import com.db.post.postbook.restServices.UserPost
import org.koin.core.inject

class PostCommentsViewModel : BaseViewModel(){

    val userModel: UserModel by inject()


    lateinit var  userPost:UserPost

     fun init() {

        userPost = userModel.getCurrentUserPost()

    }




}