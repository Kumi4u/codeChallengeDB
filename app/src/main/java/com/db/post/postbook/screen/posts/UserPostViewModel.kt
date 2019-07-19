package com.db.post.postbook.screen.posts

import com.db.post.postbook.base.BaseViewModel
import com.db.post.postbook.navigation.HomeNavigation
import com.db.post.postbook.restServices.UserPost
import org.koin.core.KoinComponent

class UserPostViewModel : BaseViewModel(), KoinComponent {
    fun onUserPostClick(post: UserPost) {

        navigate(HomeNavigation.ToPostInformation)
    }


}