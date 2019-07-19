package com.db.post.postbook.screen.comments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.viewModels
import com.db.post.postbook.R
import com.db.post.postbook.base.BaseFragment
import com.db.post.postbook.base.BaseViewModel
import com.db.post.postbook.databinding.FragmentPostCommentsBinding

class PostCommentsFragment : BaseFragment() {


    val viewModel: PostCommentsViewModel by viewModels()
    lateinit var binding: FragmentPostCommentsBinding

    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

    override fun doDataBinding(inflater: LayoutInflater, container: ViewGroup?): ViewDataBinding {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_post_comments,container,false)
        binding.viewModel = viewModel
        return binding
    }
}

