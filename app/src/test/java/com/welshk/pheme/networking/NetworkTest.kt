package com.welshk.pheme.networking

import org.junit.Before
import org.junit.Test
import com.welshk.pheme.model.NewsResponse
import org.junit.Assert
import retrofit2.Response


class NetworkTest {

    @Before
    fun setup() {
        //Setup everything for the tests...
    }

    @Test
    fun getTopHeadlines() {
        //Get top head lines
        api_getTopHeadlines("us")
    }

    private fun api_getTopHeadlines(country : String): Response<NewsResponse>? {
        val call = NewsApiManager.getTopHeadlines(country)

        val response = call.execute()
        Assert.assertNotNull(response)
        Assert.assertTrue(response.isSuccessful)
        Assert.assertNotNull(response.body())
        Assert.assertEquals(response.body()!!.status, "ok")

        return response
    }
}