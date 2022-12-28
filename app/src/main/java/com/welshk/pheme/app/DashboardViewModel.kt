package com.welshk.pheme.app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.welshk.pheme.model.NewsResponse
import com.welshk.pheme.networking.ApplicationDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(private val repository: ApplicationDataRepository) :
    ViewModel() {

    val news: LiveData<NewsResponse>
        get() = _news
    private val _news = MutableLiveData<NewsResponse>()

    init {
        fetchNews()
    }

    fun fetchNews(){
        viewModelScope.launch {
            val response = repository.getTopHeadlines("Apple")
            if (response.isSuccessful) {
                val details = response.body()
                details?.let {
                    _news.postValue(it)
                }
            } else {
                //Handle error UI stuff here
            }
        }
    }
}