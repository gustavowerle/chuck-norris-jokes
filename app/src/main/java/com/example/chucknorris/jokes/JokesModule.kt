package com.example.chucknorris.jokes

import org.koin.dsl.module
import retrofit2.Retrofit

val jokes = module {
    factory {
        provideJokesREST(get())
    }
    factory {
        provideIJokeRepository(get())
    }
}

fun provideIJokeRepository(api: IJokesREST): IJokesRepository =
    JokesRepository(api)

fun provideJokesREST(retrofit: Retrofit): IJokesREST =
    retrofit.create(IJokesREST::class.java)