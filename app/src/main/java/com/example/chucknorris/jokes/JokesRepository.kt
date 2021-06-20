package com.example.chucknorris.jokes

import androidx.paging.PagingSource
import com.example.chucknorris.database.jokes.IJokeDAO
import com.example.chucknorris.database.jokes.toJokeEntity

class JokesRepository(
    private val api: IJokesREST,
    private val dao: IJokeDAO
) : IJokesRepository {

    override fun getAll(): PagingSource<Int, JokeDTO> {
        return dao.getAll()
    }

    override fun save(joke: JokeDTO) {
        dao.create(joke.toJokeEntity())
    }

    override fun getARandomJokeFromServer(): JokeDTO? {
        val response = api.getARandomJoke().execute()
        if (response.code() != 200)
            throw Exception("Sorry, but we can't get a new joke, please try again later")
        return response.body()
    }

    override fun getJokesCategories(): ArrayList<String>? {
        val response = api.getJokesCategories().execute()
        if (response.code() != 200)
            throw Exception("Sorry, but we can't get the categories, please try again later")
        return response.body()
    }
}