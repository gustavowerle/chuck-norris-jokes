package com.example.chucknorris.database.jokes

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.chucknorris.jokes.JokeDTO

@Dao
interface IJokeDAO {

    @Query("SELECT * FROM jokes ORDER BY date DESC")
    fun getAll(): PagingSource<Int, JokeDTO>

    @Insert
    fun create(joke: JokeEntity)

}