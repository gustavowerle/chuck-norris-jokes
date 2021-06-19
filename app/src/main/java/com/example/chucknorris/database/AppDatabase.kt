package com.example.chucknorris.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.chucknorris.database.jokes.JokeDAO
import com.example.chucknorris.database.jokes.JokeEntity

@Database(
    entities = [
        JokeEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun jokeDAO(): JokeDAO

}