package com.db.post.postbook.screen.posts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.db.post.postbook.base.OnPostClickListener
import com.db.post.postbook.base.OnPostFavClickListener
import com.db.post.postbook.databinding.ItemUserPostBinding
import com.db.post.postbook.restServices.UserPost

class UserPostAdapter(var userPostList: List<UserPost>, val onPostClickListener: OnPostClickListener, val onPostFavClickListner: OnPostFavClickListener) :
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
        holder.bind(userPost, onPostClickListener)

    }


    class UserPostViewHolder(val binding: ItemUserPostBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(userPost: UserPost, onPostClickListener: OnPostClickListener) {
            binding.userPost = userPost
            binding.clickListener = onPostClickListener

        }
    }


}