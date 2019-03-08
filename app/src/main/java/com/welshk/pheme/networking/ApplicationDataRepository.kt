package com.welshk.pheme.networking

import com.welshk.pheme.model.NewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ApplicationDataRepository {

    fun getTopHeadlines(query: String?, country: String?, category: String?, page: String?, onComplete: (newsResponse : NewsResponse) -> Unit, onFail: (throwable : Throwable) -> Unit) {
        NewsApiManager.getTopHeadlines(query, country, category, page).enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>?, response: Response<NewsResponse>?) {
                response?.body()?.let { onComplete(it) }
            }

            override fun onFailure(call: Call<NewsResponse>?, t: Throwable?) {
                t?.let { onFail(it) }
            }
        })
    }


}