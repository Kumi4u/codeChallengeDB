package com.db.post.postbook.screen.posts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.viewModels
import com.db.post.postbook.R
import com.db.post.postbook.base.BaseFragment
import com.db.post.postbook.base.BaseViewModel
import com.db.post.postbook.databinding.FragmentUserFavPostBinding


class UserFavPostFragment : BaseFragment() {
    val viewModel: UserFavPostViewModel by viewModels()
    lateinit var binding: FragmentUserFavPostBinding


    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

    override fun doDataBinding(inflater: LayoutInflater, container: ViewGroup?): ViewDataBinding {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_fav_post, container, false)
        binding.viewModel = viewModel

        return binding
    }

}
