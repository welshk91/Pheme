package com.welshk.pheme.networking

import org.junit.Before
import org.junit.Test
import com.welshk.pheme.model.NewsResponse
import org.junit.Assert
import retrofit2.Response


class TopHeadlinesNetworkTest {

    @Before
    fun setup() {
        //Setup everything for the tests...
    }

    @Test
    fun testTopHeadlines() {
        //Get top head lines
        getTopHeadlines("Apple", "us", null, null)
        getTopHeadlines(null, "ars-technica,ign", null)
        getTopHeadlines(null, "us", "technology", null)
    }

    private fun getTopHeadlines(query: String?, country: String?, category: String?, page: String?): Response<NewsResponse>? {
        val call = NewsApiManager.getTopHeadlines(query, country, category, page)

        val response = call.execute()
        Assert.assertNotNull(response)
        Assert.assertTrue(response.isSuccessful)
        Assert.assertNotNull(response.body())
        Assert.assertEquals(response.body()!!.status, "ok")

        return response
    }

    private fun getTopHeadlines(query: String?, sources: String?, page: String?): Response<NewsResponse>? {
        val call = NewsApiManager.getTopHeadlines(query, sources, page)

        val response = call.execute()
        Assert.assertNotNull(response)
        Assert.assertTrue(response.isSuccessful)
        Assert.assertNotNull(response.body())
        Assert.assertEquals(response.body()!!.status, "ok")

        return response
    }
}