package com.weekendwars.hc.domain.service.impl

import com.weekendwars.hc.domain.dto.Book
import com.weekendwars.hc.domain.service.HCService
import kotlinx.coroutines.flow.flow

class RapidApiHCServiceImpl(private val service: RapidApiHCService) : HCService {

    /**
     * Fetches from the RapidApi service a list of Books
     */
    override suspend fun getBooks() = flow {
        emit(service.getBooks().map {
            Book(it.books.split(",").map {
                it.trim()
            })
        })
    }
}