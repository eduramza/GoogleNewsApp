package com.eduramza.googlenewsapp.app

import com.eduramza.googlenewsapp.data.repository.NewsRepository
import com.eduramza.googlenewsapp.data.repository.NewsRepositoryImpl
import com.eduramza.googlenewsapp.data.source.NewsClient
import com.eduramza.googlenewsapp.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val newsModules= module {
    single { NewsClient.createNewsService() }
    single<NewsRepository> { NewsRepositoryImpl(get()) }
    viewModel{HomeViewModel(get())}
}