package com.example.githubtask.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubtask.R
import com.example.githubtask.databinding.SingleRepoItemBinding
import com.example.githubtask.model.Repository


class RecyclerViewAdapter(private var repos: List<Repository>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: SingleRepoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(repo: Repository) {
            binding.apply {

                usernameTextview.text = repo.owner.login
                repositoryNameTextview.text = repo.name
                starsCountTextview.text = repo.stargazers_count.toString()
                descriptionTextview.text = repo.description

                Glide.with(itemView)
                    .load(repo.owner.avatar_url)
                    .placeholder(R.drawable.ic_launcher_background)
                    .override(60, 50)
                    .into(userAvatar)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SingleRepoItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val repo = repos[position]
        holder.bind(repo)
    }

    override fun getItemCount(): Int {
        return repos.size
    }

    fun setData(list: List<Repository>){
        this.repos = list
        notifyDataSetChanged()
    }
}