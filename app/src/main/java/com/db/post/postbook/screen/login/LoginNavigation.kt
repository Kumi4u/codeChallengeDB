package com.db.post.postbook.screen.login

import com.db.post.postbook.navigation.Navigation
import com.db.post.postbook.navigation.NavigationCommand

sealed class LoginNavigation(override val navigationCommand: NavigationCommand) :
    Navigation {

    object ToPosts : LoginNavigation(
        NavigationCommand.To(LoginFragmentDirections.actionLoginFragmentToUserPostFragment())
    )


}