package com.db.post.postbook.screen.posts

import androidx.lifecycle.MutableLiveData
import com.db.post.postbook.base.BaseViewModel
import com.db.post.postbook.model.UserModel
import com.db.post.postbook.navigation.HomeNavigation
import com.db.post.postbook.restServices.UserPost
import org.koin.core.inject

class UserFavPostViewModel : BaseViewModel(){

    val userModel: UserModel by inject()

    val usePostsMutableLiveData = MutableLiveData<List<UserPost>>()



    fun init(){
        usePostsMutableLiveData.value= userModel.getFavPosts()
    }


    fun onUserPostClick(post: UserPost) {

        navigate(HomeNavigation.ToPostInformation)
    }

    fun onPostFavClicked(post: UserPost) {

        userModel.updatePostLikeness(post)
        init()
    }

}