package com.welshk.pheme.networking

import com.welshk.pheme.BuildConfig
import com.welshk.pheme.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsApiService {
    //Examples
    //https://newsapi.org/v2/top-headlines?country=us&apiKey=a6be2141d63e447e9a0b56c42df8417a&page=2
    //https://newsapi.org/v2/everything?sources=ars-technica&apiKey=a6be2141d63e447e9a0b56c42df8417a

    @GET("/v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("apiKey") apikey: String? = BuildConfig.API_KEY,
        @Query("q") query: String?,
        @Query("sources") sources: String?,
        @Query("pageSize") pageSize: String? = "25",
        @Query("page") page: String? = "1"
    ): Response<NewsResponse>

    @GET("/v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("apiKey") apikey: String? = BuildConfig.API_KEY,
        @Query("q") query: String?,
        @Query("country") country: String?,
        @Query("category") category: String?,
        @Query("pageSize") pageSize: String? = "25",
        @Query("page") page: String? = "1"
    ): Response<NewsResponse>

    @GET("/v2/everything")
    suspend fun getEverything(
        @Query("apiKey") apikey: String? = BuildConfig.API_KEY,
        @Query("q") query: String?,
        @Query("sources") sources: String?,
        @Query("domains") domains: String?,
        @Query("excludeDomains") excludedDomains: String?,
        @Query("from") from: String?,
        @Query("to") to: String?,
        @Query("language") language: String?,
        @Query("sortBy") sortBy: String?,
        @Query("pageSize") pageSize: String? = "25",
        @Query("page") page: String? = "1"
    ): Response<NewsResponse>
}