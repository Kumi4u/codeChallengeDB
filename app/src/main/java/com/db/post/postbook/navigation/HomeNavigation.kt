package com.db.post.postbook.navigation

import com.db.post.postbook.screen.login.LoginFragmentDirections

sealed class HomeNavigation(override val navigationCommand: NavigationCommand) :
    Navigation {

    object ToPostInformation : HomeNavigation(
        NavigationCommand.To(LoginFragmentDirections.globalToPostCommentsFragment())
    )


}