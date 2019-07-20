package com.db.post.postbook.screen.posts

import androidx.lifecycle.MutableLiveData
import com.db.post.postbook.base.BaseViewModel
import com.db.post.postbook.base.OnPostClickListener
import com.db.post.postbook.model.UserModel
import com.db.post.postbook.navigation.HomeNavigation
import com.db.post.postbook.restServices.UserPost
import org.koin.core.inject

class UserFavPostViewModel : BaseViewModel(), OnPostClickListener{

    val userModel: UserModel by inject()

    val usePostsMutableLiveData = MutableLiveData<List<UserPost>>()



    fun init(){
        usePostsMutableLiveData.value= userModel.getFavPosts()
    }


    override fun onPostClick(post: UserPost) {
        userModel.setCurrentPost(post)
        navigate(HomeNavigation.ToPostInformation)
    }

    override fun onFavClick(post: UserPost) {
        userModel.updatePostLikeness(post)
        init()
    }

}