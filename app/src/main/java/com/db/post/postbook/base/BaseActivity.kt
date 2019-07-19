package com.db.post.postbook.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.db.post.postbook.navigation.NavigationCommand
import com.db.post.postbook.navigation.NavigationHandler

abstract class BaseActivity : AppCompatActivity() {

    lateinit var navigationHandler: Observer<NavigationCommand>
    abstract fun doDataBinding(): ViewDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigationHandler = initNavigationCommandHandler()
        val viewDataBinding = doDataBinding()
        viewDataBinding.lifecycleOwner = this
    }

    open fun initNavigationCommandHandler(): Observer<NavigationCommand> {
        return NavigationHandler(this)
    }


}