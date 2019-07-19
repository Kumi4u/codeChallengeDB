package com.db.post.postbook.screen.comments

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.db.post.postbook.R
import com.db.post.postbook.base.BaseFragment
import com.db.post.postbook.databinding.FragmentPostCommentsBinding

class PostCommentsFragment : BaseFragment() {

    lateinit var viewModel: PostCommentsViewModel
    lateinit var binding: FragmentPostCommentsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupViewModel()
        bindView()

    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(this).get(PostCommentsViewModel::class.java)
    }

    private fun bindView() {

        binding = DataBindingUtil.setContentView(baseActivity!!, R.layout.fragment_post_comments)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

    }

}
