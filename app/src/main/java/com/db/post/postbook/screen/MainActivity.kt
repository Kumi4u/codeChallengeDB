package com.db.post.postbook.screen

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.db.post.postbook.R
import com.db.post.postbook.base.BaseActivity
import com.db.post.postbook.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private lateinit var dataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding.bottomNavigationView.setupWithNavController(findNavController(R.id.nav_fragment))

        findNavController(R.id.nav_fragment).addOnDestinationChangedListener { _, destination, args ->


            dataBinding.bottomNavigationView.visibility =
                if (destinationIsPost(destination)) View.VISIBLE else View.GONE
        }
    }

    override fun doDataBinding(): ViewDataBinding {
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        return dataBinding
    }

    private fun destinationIsPost(destination: NavDestination): Boolean {
        return destination.id == R.id.userFavPostFragment || destination.id == R.id.userPostFragment
    }
}
