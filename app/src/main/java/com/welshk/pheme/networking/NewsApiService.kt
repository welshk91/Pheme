package com.welshk.pheme.networking

import com.welshk.pheme.BuildConfig
import com.welshk.pheme.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsApiService {

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
        @Query("q") query: String? = null,
        @Query("sources") sources: String? = null,
        @Query("domains") domains: String? = null,
        @Query("excludeDomains") excludedDomains: String? = null,
        @Query("from") from: String? = null,
        @Query("to") to: String? = null,
        @Query("language") language: String? = null,
        @Query("sortBy") sortBy: String? = null,
        @Query("pageSize") pageSize: String? = "25",
        @Query("page") page: String? = "1"
    ): Response<NewsResponse>
}