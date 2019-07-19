package com.db.post.postbook

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.db.post.postbook.base.BaseActivity
import com.db.post.postbook.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private lateinit var dataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding.bottomNavigationView.setupWithNavController(findNavController(R.id.nav_fragment))
    }

    override fun doDataBinding(): ViewDataBinding {
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        return dataBinding

    }

}
