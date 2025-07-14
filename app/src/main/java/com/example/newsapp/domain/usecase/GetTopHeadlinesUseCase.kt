package com.example.newsapp.domain.usecase

import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.repository.NewsRepository

class GetTopHeadlinesUseCase (private val repository: NewsRepository) {
    suspend operator fun invoke(): List<Article> = repository.getTopHeadlines()
}
