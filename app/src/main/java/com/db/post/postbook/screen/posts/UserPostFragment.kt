package com.db.post.postbook.screen.posts

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.db.post.postbook.R
import com.db.post.postbook.base.BaseFragment
import com.db.post.postbook.databinding.FragmentUserPostBinding

class UserPostFragment : BaseFragment() {

    lateinit var viewModel: UserPostViewModel
    lateinit var binding: FragmentUserPostBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupViewModel()
        bindView()

    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(this).get(UserPostViewModel::class.java)
    }

    private fun bindView() {

        binding = DataBindingUtil.setContentView(baseActivity!!, R.layout.fragment_user_post)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

    }

}
