package com.db.post.postbook.screen.posts

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.db.post.postbook.base.BaseViewModel
import com.db.post.postbook.model.UserModel
import com.db.post.postbook.navigation.HomeNavigation
import com.db.post.postbook.restServices.UserPost
import org.koin.core.inject

class UserPostViewModel : BaseViewModel() {

    val userModel: UserModel by inject()

    val usePostsMutableLiveData = MutableLiveData<List<UserPost>>()



    fun init(){
        usePostsMutableLiveData.value= userModel.getCurrentUser().userPostList
    }


    fun onUserPostClick(post: UserPost) {

        Log.e("kumi","post is " + userModel)
        userModel.setCurrentPost(post)
        navigate(HomeNavigation.ToPostInformation)
    }

    fun onPostFavClicked(post: UserPost) {

        userModel.updatePostLikeness(post)
        init()
    }



}