package com.db.post.postbook.navigation

import com.db.post.postbook.screen.login.LoginFragmentDirections

sealed class LoginNavigation(override val navigationCommand: NavigationCommand) :
    Navigation {

    object ToPosts : LoginNavigation(
        NavigationCommand.To(LoginFragmentDirections.actionLoginFragmentToUserPostFragment())
    )


}