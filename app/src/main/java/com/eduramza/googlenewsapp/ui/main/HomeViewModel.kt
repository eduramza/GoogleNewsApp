package com.eduramza.googlenewsapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

enum class MyStatus{LOADING, ERROR, DONE}

class HomeViewModel : ViewModel() {

    private val _status = MutableLiveData<MyStatus>()
    val status: LiveData<MyStatus>
        get() = _status

}