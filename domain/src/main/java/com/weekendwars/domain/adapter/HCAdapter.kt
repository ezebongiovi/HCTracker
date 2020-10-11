package com.weekendwars.domain.adapter

import com.weekendwars.domain.interceptor.RapidApiHeadersInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HCAdapter {

    companion object {
        private val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(RapidApiHeadersInterceptor())
            .build()

        val retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://ajith-holy-bible.p.rapidapi.com/")
            .client(client)
            .build()
    }
}