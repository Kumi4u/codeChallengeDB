package com.db.post.postbook.navigation

import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.db.post.postbook.R
import com.db.post.postbook.base.BaseActivity

class NavigationHandler(private val baseActivity: BaseActivity) : Observer<NavigationCommand> {
    override fun onChanged(command: NavigationCommand) {
        when (command) {
            is NavigationCommand.To
            -> baseActivity.findNavController(R.id.nav_fragment).navigate(command.directions)
            is NavigationCommand.BackTo
            -> baseActivity.findNavController(R.id.nav_fragment).popBackStack(command.destinationId, false)
            is NavigationCommand.Back
            -> baseActivity.findNavController(R.id.nav_fragment).popBackStack()
        }
    }
}
