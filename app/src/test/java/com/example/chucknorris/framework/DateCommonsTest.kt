package com.example.chucknorris.framework

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.util.*

private const val DATE_STRING = "2021-11-06T15:14:00.000"

class DateCommonsTest {

    private lateinit var date: Date

    @Before
    fun setUp() {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.YEAR, 2021)
        calendar.set(Calendar.MONTH, 10)
        calendar.set(Calendar.DAY_OF_MONTH, 6)
        calendar.set(Calendar.HOUR_OF_DAY, 15)
        calendar.set(Calendar.MINUTE, 14)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)

        date = calendar.time
    }

    @Test
    fun `when date expect formatted date string`() {
        val obtained = DateCommons.toISOString(date)

        assertEquals(DATE_STRING, obtained)
    }
}