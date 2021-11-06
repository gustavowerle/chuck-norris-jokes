package com.example.chucknorris.database.jokes

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.filters.SmallTest
import com.example.chucknorris.database.AppDatabase
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.*

@SmallTest
class JokeDAOTest {

    private lateinit var jokeDao: IJokeDAO

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: AppDatabase

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()

        jokeDao = database.jokeDAO()
    }

    @Test
    fun when_creating_a_joke_expect_it_was_created() = runBlocking {
        val jokeId = UUID.randomUUID().toString()
        val joke = JokeDTO(
            id = jokeId,
            icon_url = "icon_url",
            url = "url",
            value = "value",
            date = "date"
        )

        jokeDao.create(joke.toJokeEntity())

        jokeDao.getAll().forEach {
            assertEquals(jokeId, it.id)
        }
    }
}