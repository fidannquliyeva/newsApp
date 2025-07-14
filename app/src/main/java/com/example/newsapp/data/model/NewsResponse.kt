package com.example.newsapp.data.model

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleDto>
)

data class ArticleDto(
    val title: String?,
    val description: String?,
    val urlToImage: String?
)