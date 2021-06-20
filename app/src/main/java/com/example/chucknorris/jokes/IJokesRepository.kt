package com.example.chucknorris.jokes

import androidx.paging.PagingSource

interface IJokesRepository {

    fun getAll(): PagingSource<Int, JokeDTO>

    fun save(joke: JokeDTO)

    fun getARandomJokeFromServer(): JokeDTO?

    fun getJokesCategories(): ArrayList<String>?

}