package com.weekendwars.domain.service

import com.weekendwars.domain.dto.Book
import kotlinx.coroutines.flow.Flow

interface HCService {

    /**
     * Fetches from the source a list of Books
     */
    suspend fun getBooks(): Flow<List<Book>>
}