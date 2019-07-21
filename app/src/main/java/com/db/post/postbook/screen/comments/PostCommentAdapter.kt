package com.db.post.postbook.screen.comments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.db.post.postbook.databinding.ItemCommentsBinding
import com.db.post.postbook.restServices.UserComment

class PostCommentAdapter(private var userCommentList: List<UserComment>) :
    RecyclerView.Adapter<PostCommentAdapter.UserPostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserPostViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCommentsBinding.inflate(layoutInflater, parent, false)
        return UserPostViewHolder(binding)
    }

    override fun getItemCount(): Int {

        return userCommentList.size
    }

    override fun onBindViewHolder(holder: UserPostViewHolder, position: Int) {

        val userComment = userCommentList[position]
        holder.binding.userComment = userComment

    }


    class UserPostViewHolder(val binding: ItemCommentsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(userComment: UserComment) {
            binding.userComment = userComment

        }
    }


}