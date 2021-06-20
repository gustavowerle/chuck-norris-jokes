package com.example.chucknorris.jokes

import retrofit2.Call
import retrofit2.http.GET

interface IJokesREST {

    @GET("jokes/random")
    fun getARandomJoke(): Call<JokeDTO?>

    @GET("jokes/categories")
    fun getJokesCategories(): Call<ArrayList<String>?>

}