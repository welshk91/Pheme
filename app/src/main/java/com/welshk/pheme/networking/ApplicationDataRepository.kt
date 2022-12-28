package com.welshk.pheme.networking

import com.welshk.pheme.model.NewsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Singleton

@Singleton
class ApplicationDataRepository {

    suspend fun getTopHeadlines(
        query: String?,
        country: String? = null,
        category: String? = null,
        page: String? = "1"
    ): Response<NewsResponse> = withContext(Dispatchers.IO) {
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