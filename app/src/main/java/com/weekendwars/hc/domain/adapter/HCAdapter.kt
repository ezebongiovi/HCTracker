package com.weekendwars.hc.domain.adapter

import com.weekendwars.hc.domain.interceptor.RapidApiHeadersInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HCAdapter {

    private val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(RapidApiHeadersInterceptor())
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://ajith-holy-bible.p.rapidapi.com/")
        .client(client)
        .build()
}