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

    val newsLoading: LiveData<Boolean>
        get() = _newsLoading
    private val _newsLoading = MutableLiveData<Boolean>()

    init {
        fetchNews()
    }

    fun fetchNews() {
        _newsLoading.postValue(true)
        viewModelScope.launch {
            val response = repository.getEverything("ars-technica")
            if (response.isSuccessful) {
                _newsLoading.postValue(false)
                val details = response.body()
                details?.let {
                    _news.postValue(it)
                }
            } else {
                _newsLoading.postValue(false)
                //Handle error UI stuff here
            }
        }
    }
}