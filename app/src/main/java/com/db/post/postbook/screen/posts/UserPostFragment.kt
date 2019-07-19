package com.db.post.postbook.screen.posts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.db.post.postbook.R
import com.db.post.postbook.base.BaseFragment
import com.db.post.postbook.base.BaseViewModel
import com.db.post.postbook.base.OnPostClickListener
import com.db.post.postbook.databinding.FragmentUserPostBinding
import com.db.post.postbook.restServices.UserPost

class UserPostFragment : BaseFragment() {

    val viewModel: UserPostViewModel by viewModels()
    lateinit var binding: FragmentUserPostBinding
    lateinit var userPostAdapter: UserPostAdapter


    override fun getViewModel(): BaseViewModel {
        viewModel.init()
        viewModel.usePostsMutableLiveData.observe(this, Observer { item ->
            userPostAdapter.userPostList = item
            userPostAdapter.notifyDataSetChanged()
        })
        return viewModel
    }

    override fun doDataBinding(inflater: LayoutInflater, container: ViewGroup?): ViewDataBinding {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_post, container, false)
        binding.viewModel = viewModel

        setUpAdapter(binding)
        return binding
    }

    private fun setUpAdapter(binding: FragmentUserPostBinding) {

        val recyclerView = binding.allPostRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(baseActivity)

        userPostAdapter = UserPostAdapter(

            viewModel.usePostsMutableLiveData.value!!,

            object : OnPostClickListener {
                override fun onPostClick(post: UserPost) {
                    viewModel.onUserPostClick(post)
                }

            })
        recyclerView.adapter = userPostAdapter
    }

}
