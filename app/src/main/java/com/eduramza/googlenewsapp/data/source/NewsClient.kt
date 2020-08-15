package com.eduramza.googlenewsapp.data.source

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL_NEWS = "https://newsapi.org/v2/"

class NewsClient {
    companion object{
        fun createNewsService() = Retrofit.Builder()
            .baseUrl(BASE_URL_NEWS)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(NewsService::class.java)
    }
}