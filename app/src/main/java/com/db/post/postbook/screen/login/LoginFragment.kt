package com.db.post.postbook.screen.login

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.db.post.postbook.R
import com.db.post.postbook.base.BaseFragment
import com.db.post.postbook.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment() {

    lateinit var viewModel: LoginViewModel
    lateinit var binding: FragmentLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupViewModel()
        bindView()

    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
    }

    private fun bindView() {

        binding = DataBindingUtil.setContentView(baseActivity!!, R.layout.fragment_login)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

    }
}
