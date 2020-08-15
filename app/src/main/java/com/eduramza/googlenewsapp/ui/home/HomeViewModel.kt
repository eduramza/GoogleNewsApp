package com.eduramza.googlenewsapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eduramza.googlenewsapp.BuildConfig
import com.eduramza.googlenewsapp.data.model.NewsResponse
import com.eduramza.googlenewsapp.data.repository.NewsRepository
import kotlinx.coroutines.launch
import java.lang.Exception

enum class MyStatus{LOADING, ERROR, DONE}

class HomeViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    private val _status = MutableLiveData<MyStatus>()
    val status: LiveData<MyStatus> = _status

    private val _newsData = MutableLiveData<List<NewsResponse.Article>>()
    fun getNews(): LiveData<List<NewsResponse.Article>> = _newsData

    fun listHeadNews(country: String){
        viewModelScope.launch {
            _status.postValue(MyStatus.LOADING)
            try {
                val result = newsRepository.callTopHeadlinesNews(country, BuildConfig.API_KEY)
                _newsData.postValue(result.articles)
                _status.postValue(MyStatus.DONE)
            } catch (e: Exception){
                e.printStackTrace()
                _status.postValue(MyStatus.ERROR)
            }

        }
    }

}