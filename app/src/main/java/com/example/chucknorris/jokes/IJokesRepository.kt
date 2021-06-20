package com.example.chucknorris.jokes

interface IJokesRepository {

    fun getAll(): List<JokeDTO>

    fun create(joke: JokeDTO)

    fun getARandomJokeFromServer(): JokeDTO?

    fun getJokesCategories(): ArrayList<String>?

}