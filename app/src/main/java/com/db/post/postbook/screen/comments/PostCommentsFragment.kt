package com.db.post.postbook.screen.comments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.db.post.postbook.R
import com.db.post.postbook.base.BaseFragment
import com.db.post.postbook.base.BaseViewModel
import com.db.post.postbook.databinding.FragmentPostCommentsBinding

class PostCommentsFragment : BaseFragment() {


    val viewModel: PostCommentsViewModel by viewModels()
    lateinit var binding: FragmentPostCommentsBinding
    lateinit var postCommentAdapter: PostCommentAdapter

    override fun getViewModel(): BaseViewModel {
        viewModel.init()
        return viewModel
    }

    override fun doDataBinding(inflater: LayoutInflater, container: ViewGroup?): ViewDataBinding {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_post_comments,container,false)
        binding.viewModel = viewModel
        setAdapter(binding)
        return binding
    }

    private fun setAdapter(binding: FragmentPostCommentsBinding) {

        val recyclerView = binding.commentsRv
        recyclerView.layoutManager = LinearLayoutManager(baseActivity)

        postCommentAdapter = PostCommentAdapter(viewModel.userPost.userCommentList)
        recyclerView.adapter = postCommentAdapter
    }
}

