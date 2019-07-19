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

    val usePosterMutableLiveData = MutableLiveData<List<UserPost>>()



    fun init(){

        usePosterMutableLiveData.value= userModel.getCurrentUser().userPostList
    }


    fun onUserPostClick(post: UserPost) {

        navigate(HomeNavigation.ToPostInformation)
    }

    fun onPostFavClicked(post: UserPost) {

        userModel.updatePostLikeness(post)
        init()


        Log.e("kumi","is fav "+ userModel.getCurrentUser().userPostList)



    }



}