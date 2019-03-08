package com.welshk.pheme.networking

import com.welshk.pheme.BuildConfig
import com.welshk.pheme.model.NewsResponse
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

object NewsApiManager {
    private val API_KEY = BuildConfig.API_KEY

    private val NEWS_API_BASE_URL = "https://newsapi.org/"
    private val TOPHEADLINES_BASE_URL = "https://newsapi.org/v2/top-headlines"
    private val EVERYTHING_BASE_URL = "https://newsapi.org/v2/everything"

    private val newsApiService by lazy {
        getRetroFitService()
    }

    private fun getRetroFitService(): NewsApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(NEWS_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(NewsApiService::class.java)
    }

    fun getTopHeadlines(query: String?, sources: String?, page: String?): Call<NewsResponse> {
        return newsApiService.getTopHeadlines(TOPHEADLINES_BASE_URL, API_KEY, query, sources, page)
    }

    fun getTopHeadlines(query: String?, country: String?, category: String?, page: String?): Call<NewsResponse> {
        return newsApiService.getTopHeadlines(TOPHEADLINES_BASE_URL, API_KEY, query, country, category, page)
    }
}