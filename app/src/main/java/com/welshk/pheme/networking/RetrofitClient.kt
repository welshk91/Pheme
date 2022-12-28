package com.welshk.pheme.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.mock.BehaviorDelegate
import retrofit2.mock.MockRetrofit
import retrofit2.mock.NetworkBehavior

object RetrofitClient {
    private val NEWS_API_BASE_URL = "https://newsapi.org/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(NEWS_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getMockInstance(networkBehavior: NetworkBehavior): NewsApiService {
        val retrofitClient = Retrofit.Builder()
            .baseUrl(NEWS_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val mockRetrofitService = MockRetrofit.Builder(retrofitClient)
            .networkBehavior(networkBehavior)
            .build()

        val delegate: BehaviorDelegate<NewsApiService> = mockRetrofitService.create(
            NewsApiService::class.java
        )

        return MockNewsApiService(delegate)
    }
}