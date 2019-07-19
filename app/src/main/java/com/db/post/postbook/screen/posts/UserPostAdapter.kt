package com.db.post.postbook.screen.posts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.db.post.postbook.base.OnUserPostClickListener
import com.db.post.postbook.databinding.ItemUserPostBinding
import com.db.post.postbook.restServices.UserPost

class UserPostAdapter(val userPostList: List<UserPost>, val onUserPostClickListener: OnUserPostClickListener) :
    RecyclerView.Adapter<UserPostAdapter.UserPostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserPostViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemUserPostBinding.inflate(layoutInflater, parent, false)
        return UserPostViewHolder(binding)
    }

    override fun getItemCount(): Int {

        return userPostList.size
    }

    override fun onBindViewHolder(holder: UserPostViewHolder, position: Int) {

        val userPost = userPostList.get(position)
        holder.bind(userPost, onUserPostClickListener)

    }


    class UserPostViewHolder(val binding: ItemUserPostBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(userPost: UserPost, onUserPostClickListener: OnUserPostClickListener) {
            binding.userPost = userPost
            binding.clickListener = onUserPostClickListener

        }
    }


}