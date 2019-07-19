package com.db.post.postbook.screen.posts

import android.util.Log
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
import com.db.post.postbook.base.OnPostFavClickListener
import com.db.post.postbook.databinding.FragmentUserPostBinding
import com.db.post.postbook.restServices.UserPost

class UserPostFragment : BaseFragment() {

    val viewModel: UserPostViewModel by viewModels()
    lateinit var binding: FragmentUserPostBinding
    lateinit var userPostAdapter: UserPostAdapter


    override fun getViewModel(): BaseViewModel {
        viewModel.init()
        viewModel.usePosterMutableLiveData.observe(this, Observer { item ->
            userPostAdapter.userPostList
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
        Log.e("kumi", "list is "+ viewModel.usePosterMutableLiveData.value)

        userPostAdapter = UserPostAdapter(

            viewModel.usePosterMutableLiveData.value!!,

            object : OnPostClickListener {
                override fun onPostClick(post: UserPost) {
                    viewModel.onUserPostClick(post)
                }

            },
            object : OnPostFavClickListener {
                override fun onFavClick(post: UserPost) {
                    viewModel.onPostFavClicked(post)
                }

            }
        )
        recyclerView.adapter = userPostAdapter
    }

}
