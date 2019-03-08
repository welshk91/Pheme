package com.welshk.pheme.networking

import org.junit.Before
import org.junit.Test
import com.welshk.pheme.model.NewsResponse
import org.junit.Assert
import retrofit2.Response


class EverythingNetworkTest {

    @Before
    fun setup() {
        //Setup everything for the tests...
    }

    @Test
    fun testEverything() {
        //Get top head lines
        getEverything("Detroit Red Wings", null, null, null, null, null, null, null, null)
        getEverything(null, "ars-technica,ign", null, null, null, null, null, null, null)
        getEverything("Apple", null, "arstechnica.com", "ign.com", null, null, "en", "popularity", null)
        getEverything("Apple", null, null, null, null, null, "en", "publishedAt", null)
    }

    private fun getEverything(query: String?, sources: String?, domains: String?, excludedDomains: String?, from : String?, to : String?, langauge : String?, sortBy : String?, page: String?): Response<NewsResponse>? {
        val call = NewsApiManager.getEverything(query, sources, domains, excludedDomains, from, to, langauge, sortBy, page)

        val response = call.execute()
        Assert.assertNotNull(response)
        Assert.assertTrue(response.isSuccessful)
        Assert.assertNotNull(response.body())
        Assert.assertEquals(response.body()!!.status, "ok")

        return response
    }
}