package com.weekendwars.domain.service.impl

import retrofit2.http.GET

interface RapidApiHCService {

    @GET("GetBooks")
    suspend fun getBooks() : List<RapidApiBook>

    data class RapidApiBook(val books: String)
}