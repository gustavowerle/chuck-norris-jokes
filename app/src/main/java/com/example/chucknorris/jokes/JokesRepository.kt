package com.example.chucknorris.jokes

class JokesRepository(
    private val api: IJokesREST
) : IJokesRepository {

    override fun getAll(): List<JokeDTO> {
        TODO("Not yet implemented")
    }

    override fun create(joke: JokeDTO) {
        TODO("Not yet implemented")
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