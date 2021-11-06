package com.example.chucknorris.database.jokes

import androidx.lifecycle.MutableLiveData

interface IJokesRepository {

    val jokes: MutableLiveData<List<JokeDTO>>

    var newJoke: MutableLiveData<JokeDTO>

    suspend fun getAll()

    suspend fun save(joke: JokeDTO)

    suspend fun getARandomJokeFromServer()

    suspend fun getJokesCategories()

}