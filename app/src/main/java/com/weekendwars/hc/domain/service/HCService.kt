package com.weekendwars.hc.domain.service

import com.weekendwars.hc.domain.dto.Book
import kotlinx.coroutines.flow.Flow

interface HCService {

    /**
     * Fetches from the source a list of Books
     */
    suspend fun getBooks(): Flow<List<Book>>
}