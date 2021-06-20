package com.example.chucknorris.jokes

import com.example.chucknorris.database.jokes.IJokeDAO
import org.koin.dsl.module
import retrofit2.Retrofit

val jokes = module {
    factory {
        provideJokesREST(get())
    }
    factory {
        provideIJokeRepository(get(), get())
    }
}

fun provideIJokeRepository(api: IJokesREST, dao: IJokeDAO): IJokesRepository =
    JokesRepository(api, dao)

fun provideJokesREST(retrofit: Retrofit): IJokesREST =
    retrofit.create(IJokesREST::class.java)