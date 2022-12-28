package com.welshk.pheme.networking

import com.welshk.pheme.BuildConfig
import com.welshk.pheme.model.NewsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.mock.NetworkBehavior
import javax.inject.Singleton

@Singleton
class ApplicationDataRepository {

    suspend fun getTopHeadlines(
        query: String?,
        country: String? = null,
        category: String? = null,
        page: String? = "1"
    ): Response<NewsResponse> = withContext(Dispatchers.IO) {
        if (BuildConfig.USE_MOCK_DATA) {
            val mockRetrofit = RetrofitClient.getMockInstance(NetworkBehavior.create())
            val mockResponse = mockRetrofit.getTopHeadlines(
                query = query,
                country = country,
                category = category,
                page = page
            )
            mockResponse
        } else {
            val retrofit = RetrofitClient.getInstance()
            val apiInterface = retrofit.create(NewsApiService::class.java)
            val response = apiInterface.getTopHeadlines(
                query = query,
                country = country,
                category = category,
                page = page
            )
            response
        }
    }

    suspend fun getEverything(sources: String, page: String? = "1"): Response<NewsResponse> =
        withContext(Dispatchers.IO) {
            if (BuildConfig.USE_MOCK_DATA) {
                val mockRetrofit = RetrofitClient.getMockInstance(NetworkBehavior.create())
                val mockResponse = mockRetrofit.getEverything(
                    sources = sources,
                    page = page
                )
                mockResponse
            } else {
                val retrofit = RetrofitClient.getInstance()
                val apiInterface = retrofit.create(NewsApiService::class.java)
                val response = apiInterface.getEverything(
                    sources = sources,
                    page = page
                )
                response
            }
        }
}