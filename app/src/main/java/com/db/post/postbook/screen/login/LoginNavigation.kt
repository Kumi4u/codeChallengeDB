package com.db.post.postbook.screen.login

import com.db.post.postbook.navigation.Navigation
import com.db.post.postbook.navigation.NavigationCommand
import com.db.post.postbook.restServices.User

sealed class LoginNavigation(override val navigationCommand: NavigationCommand) :
    Navigation {

    data class ToPosts(val user: User) : LoginNavigation(
        NavigationCommand.To(LoginFragmentDirections.actionLoginFragmentToUserPostFragment(user))
    )


}