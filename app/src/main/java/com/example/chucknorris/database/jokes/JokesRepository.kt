package com.example.chucknorris.database.jokes

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class JokesRepository(
    private val api: IJokesREST,
    private val dao: IJokeDAO,
    private val coroutineScope: CoroutineDispatcher = Dispatchers.IO
) : IJokesRepository {

    override val jokes = MutableLiveData<List<JokeDTO>>()
    override var newJoke = MutableLiveData<JokeDTO>()

    override suspend fun getAll() {
        withContext(coroutineScope) {
            jokes.postValue(dao.getAll())
        }
    }

    override suspend fun save(joke: JokeDTO) {
        withContext(coroutineScope) {
            dao.create(joke.toJokeEntity())
            getAll()
        }
    }

    override suspend fun getARandomJokeFromServer() {
        withContext(coroutineScope) {
            val response = api.getARandomJoke().execute()
            if (response.code() != 200)
                throw Exception("Sorry, but we can't get a new joke, please try again later")
            response.body()?.let {
                newJoke.postValue(it)
                save(it)
            }
        }
    }

    override suspend fun getJokesCategories() {
        val response = api.getJokesCategories().execute()
        if (response.code() != 200)
            throw Exception("Sorry, but we can't get the categories, please try again later")
//        return response.body()
    }
}