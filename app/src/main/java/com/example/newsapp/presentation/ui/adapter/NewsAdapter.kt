package com.example.newsapp.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.databinding.ItemNewsBinding
import com.example.newsapp.domain.model.Article

class NewsAdapter() : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    private val newsList = mutableListOf<Article>(
        Article("Title 1", "Description 1", "https://example.com/image1.jpg"),
        Article("Title 2", "Description 2", "https://example.com/image2.jpg"),

    )


    inner class NewsViewHolder(val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.tvTitle.text = article.title
            binding.tvDescription.text = article.description
            Glide.with(binding.ivThumbnail.context)
                .load(article.imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.ivThumbnail)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(newsList[position])
    }

    override fun getItemCount() = newsList.size

    fun submitList(newList: List<Article>) {
        newsList.clear()
        newsList.addAll(newList)
        notifyDataSetChanged()
    }
}
