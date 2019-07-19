package com.db.post.postbook.screen.posts

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.db.post.postbook.R
import com.db.post.postbook.base.BaseFragment
import com.db.post.postbook.databinding.FragmentUserFavPostBinding

class UserFavPostFragment : BaseFragment() {
    lateinit var viewModel: UserFavPostViewModel
    lateinit var binding: FragmentUserFavPostBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupViewModel()
        bindView()

    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(this).get(UserFavPostViewModel::class.java)
    }

    private fun bindView() {

        binding = DataBindingUtil.setContentView(baseActivity!!, R.layout.fragment_user_fav_post)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

    }

}
