package com.weekendwars.domain.interceptor

import okhttp3.Interceptor
import okhttp3.Response

const val HEADER_X_RAPIDAPI_HOST = "x-rapidapi-host"
const val HEADER_X_RAPIDAPI_KEY = "x-rapidapi-key"
const val HEADER_HOST_VALUE = "ajith-holy-bible.p.rapidapi.com"
const val HEADER_KEY_VALUE = "35ebdf1a55msh51eb826e1133d45p1bf17bjsne2295f8d5698"

class RapidApiHeadersInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader(HEADER_X_RAPIDAPI_HOST, HEADER_HOST_VALUE)
            .addHeader(HEADER_X_RAPIDAPI_KEY, HEADER_KEY_VALUE)
            .build()

        return chain.proceed(request)
    }
}