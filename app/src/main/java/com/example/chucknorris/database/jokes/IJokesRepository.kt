package com.example.chucknorris.database.jokes

import com.example.chucknorris.jokes.JokeDTO

interface IJokesRepository {

    fun getAll(): List<JokeDTO>

    fun create(joke: JokeDTO)

}