package com.example.chucknorris.database.jokes

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface JokeDAO {

    @Query("SELECT * FROM jokes")
    fun getAll(): List<JokeEntity>

    @Insert
    fun create(joke: JokeEntity)

}