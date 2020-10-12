package com.weekendwars.hc.domain.service.impl

import com.weekendwars.hc.domain.dto.Book
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Test

class RapidApiHCServiceImplTest {

    @Test
    fun mappingWithSpaces() = runBlockingTest {
        val stubbedService = mockk<RapidApiHCService>()
        val objectUnderTest = RapidApiHCServiceImpl(stubbedService)

        coEvery { stubbedService.getBooks() } coAnswers {
            listOf(RapidApiHCService.RapidApiBook("Test, Test2"))
        }

        val result = objectUnderTest.getBooks().first()

        val expectedResult = listOf(
            Book(listOf("Test", "Test2"))
        )

        assertEquals(expectedResult, result)
        assertEquals("Test2", result[0].books[1])
    }

    @Test
    fun mappingWithNoSpaces() = runBlockingTest {
        val stubbedService = mockk<RapidApiHCService>()
        val objectUnderTest = RapidApiHCServiceImpl(stubbedService)

        coEvery { stubbedService.getBooks() } coAnswers {
            listOf(RapidApiHCService.RapidApiBook("Test,Test2"))
        }

        val result = objectUnderTest.getBooks().first()

        val expectedResult = listOf(
            Book(listOf("Test", "Test2"))
        )

        assertEquals(expectedResult, result)
        assertEquals(expectedResult[0].books, result[0].books)
    }
}