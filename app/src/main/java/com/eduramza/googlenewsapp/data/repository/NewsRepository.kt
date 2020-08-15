package com.eduramza.googlenewsapp.data.repository

import com.eduramza.googlenewsapp.data.model.NewsResponse
import com.eduramza.googlenewsapp.data.source.NewsService

interface NewsRepository {
    suspend fun callTopHeadlinesNews(country: String, apiKey: String): NewsResponse
}

class NewsRepositoryImpl(private val api: NewsService): NewsRepository{

    override suspend fun callTopHeadlinesNews(country: String, apiKey: String)
            = api.getTopHeadlinesNews(country, apiKey)

}