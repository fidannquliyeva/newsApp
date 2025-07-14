package com.example.newsapp.data.mapper

import com.example.newsapp.data.model.ArticleDto
import com.example.newsapp.domain.model.Article

fun ArticleDto.toDomain(): Article {
    return Article(
        title = title ?: "No Title",
        description = description ?: "No Description",
        imageUrl = urlToImage ?: ""
    )
}