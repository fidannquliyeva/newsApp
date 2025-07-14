package com.example.newsapp.data.repository

import com.example.newsapp.data.api.NewsApiService
import com.example.newsapp.data.mapper.toDomain
import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.repository.NewsRepository

class NewsRepositoryImpl (private val api: NewsApiService) : NewsRepository {
    override suspend fun getTopHeadlines(): List<Article> {
        val response = api.getTopHeadlines()
        return response.articles.map { it.toDomain() }
    }
}