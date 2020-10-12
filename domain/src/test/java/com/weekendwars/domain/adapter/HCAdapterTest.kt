package com.weekendwars.domain.adapter

import com.weekendwars.domain.interceptor.HEADER_X_RAPIDAPI_HOST
import com.weekendwars.domain.interceptor.HEADER_X_RAPIDAPI_KEY
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET

class HCAdapterTest {
    private lateinit var mockWebServer: MockWebServer
    private lateinit var retrofit: Retrofit

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        mockWebServer.start()

        retrofit = HCAdapter.retrofit.newBuilder()
            .baseUrl(mockWebServer.url("/"))
            .build()
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun requestContainsHeaders() {
        val service = retrofit.create(APIService::class.java)
        val response = MockResponse()
            .setBody("{}")
            .setResponseCode(200)

        mockWebServer.enqueue(response)

        service.get().execute()

        val request = mockWebServer.takeRequest()

        assertNotNull(request.getHeader(HEADER_X_RAPIDAPI_HOST))
        assertNotNull(request.getHeader(HEADER_X_RAPIDAPI_KEY))
    }

    private interface APIService {
        @GET("test/")
        fun get(): Call<Any?>
    }
}