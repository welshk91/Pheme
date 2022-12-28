package com.welshk.pheme.networking

import com.google.gson.GsonBuilder
import com.welshk.pheme.BuildConfig
import com.welshk.pheme.model.NewsResponse
import com.welshk.pheme.utils.MockUtil
import retrofit2.Response
import retrofit2.mock.BehaviorDelegate

class MockNewsApiService(private val behaviorDelegate: BehaviorDelegate<NewsApiService>) :
    NewsApiService {

    override suspend fun getTopHeadlines(
        apikey: String?,
        query: String?,
        sources: String?,
        pageSize: String?,
        page: String?
    ): Response<NewsResponse> {
        val json = MockUtil.readJsonFile(javaClass.classLoader, BuildConfig.MOCK_ARTICLE)
        val gson = GsonBuilder().create()
        val mockArticles: NewsResponse = gson.fromJson(json, NewsResponse::class.java)
        return behaviorDelegate.returningResponse(mockArticles)
            .getTopHeadlines(apikey, query, sources, pageSize, page)
    }

    override suspend fun getTopHeadlines(
        apikey: String?,
        query: String?,
        country: String?,
        category: String?,
        pageSize: String?,
        page: String?
    ): Response<NewsResponse> {
        val json = MockUtil.readJsonFile(javaClass.classLoader, BuildConfig.MOCK_ARTICLE)
        val gson = GsonBuilder().create()
        val mockArticles: NewsResponse = gson.fromJson(json, NewsResponse::class.java)
        return behaviorDelegate.returningResponse(mockArticles)
            .getTopHeadlines(apikey, query, country, category, pageSize, page)
    }

    override suspend fun getEverything(
        apikey: String?,
        query: String?,
        sources: String?,
        domains: String?,
        excludedDomains: String?,
        from: String?,
        to: String?,
        language: String?,
        sortBy: String?,
        pageSize: String?,
        page: String?
    ): Response<NewsResponse> {
        val json = MockUtil.readJsonFile(javaClass.classLoader, BuildConfig.MOCK_ARTICLE)
        val gson = GsonBuilder().create()
        val mockArticles: NewsResponse = gson.fromJson(json, NewsResponse::class.java)
        return behaviorDelegate.returningResponse(mockArticles)
            .getEverything(
                apikey,
                query,
                sources,
                domains,
                excludedDomains,
                from,
                to,
                language,
                sortBy,
                pageSize,
                page
            )
    }
}