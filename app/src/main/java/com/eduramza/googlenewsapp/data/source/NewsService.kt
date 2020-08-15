package com.eduramza.googlenewsapp.data.source

import com.eduramza.googlenewsapp.data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("top-headlines")
    suspend fun getTopHeadlinesNews(@Query("country") country: String,
                                    @Query("apiKey") apiKey: String): NewsResponse
}