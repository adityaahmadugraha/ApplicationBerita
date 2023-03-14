package com.aditya.applicationberita.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aditya.applicationberita.Data.Articles
import com.aditya.applicationberita.databinding.ListNewsBinding
import com.bumptech.glide.Glide

class AdapterNews(onclick: () -> Unit) : ListAdapter<Articles, AdapterNews.ViewHOlder>(DIF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHOlder {
        val binding = ListNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHOlder(binding)
    }

    override fun onBindViewHolder(holder: ViewHOlder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHOlder(
        private val binding: ListNewsBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Articles)  {
            binding.title.text = data.title
            binding.description.text = data.description
            binding.author.text = data.author
            Glide.with(itemView.context)
                .load(data.urlToImage)
                .error(android.R.color.holo_green_dark)
                .into(binding.imgNews)
        }
    }

    companion object {
        val DIF_CALLBACK: DiffUtil.ItemCallback<Articles> =
            object : DiffUtil.ItemCallback<Articles>() {
                override fun areItemsTheSame(oldItem: Articles, newItem: Articles): Boolean {
                    return oldItem.title == newItem.title
                }

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(oldItem: Articles, newItem: Articles): Boolean {
                    return oldItem == newItem
                }

            }
    }
}
