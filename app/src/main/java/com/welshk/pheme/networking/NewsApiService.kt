package com.welshk.pheme.networking

import com.welshk.pheme.model.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url
import retrofit2.http.Query


interface NewsApiService {
    //Examples
    //https://newsapi.org/v2/top-headlines?country=us&apiKey=a6be2141d63e447e9a0b56c42df8417a&page=2
    //https://newsapi.org/v2/everything?sources=ars-technica&apiKey=a6be2141d63e447e9a0b56c42df8417a

    @GET
    fun getTopHeadlines(@Url url: String, @Query("apiKey") apikey: String,  @Query("q") query : String?, @Query("sources") sources: String?, @Query("page") page: String?): Call<NewsResponse>

    @GET
    fun getTopHeadlines(@Url url: String, @Query("apiKey") apikey: String,  @Query("q") query : String?, @Query("country") country: String?, @Query("category") category: String?, @Query("page") page: String?): Call<NewsResponse>
}