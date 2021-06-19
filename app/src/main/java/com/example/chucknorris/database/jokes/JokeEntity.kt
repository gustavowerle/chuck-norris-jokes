package com.example.chucknorris.database.jokes

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jokes")
data class JokeEntity(
    @PrimaryKey
    var id: String,
    var icon_url: String,
    var url: String,
    var value: String,
)
