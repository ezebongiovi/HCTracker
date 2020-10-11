package com.weekendwars.domain.service.impl

import com.weekendwars.domain.dto.Book
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
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
    }
}