package com.example.chucknorris.database.jokes

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface IJokeDAO {

    @Query("SELECT * FROM jokes ORDER BY date DESC")
    suspend fun getAll(): List<JokeDTO>

    @Insert
    fun create(joke: JokeEntity)

}