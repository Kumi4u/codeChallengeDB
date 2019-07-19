package com.db.post.postbook.screen.login

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.db.post.postbook.R
import com.db.post.postbook.base.BaseActivity
import com.db.post.postbook.databinding.ActivityLoginBinding

class LoginActivity  : BaseActivity() {

    lateinit var viewModel: LoginViewModel
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupViewModel()
        bindView()

    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
    }

    private fun bindView() {

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel

    }
}
