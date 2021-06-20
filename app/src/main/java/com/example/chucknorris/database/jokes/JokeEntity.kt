package com.example.chucknorris.database.jokes

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.chucknorris.framework.DateCommons
import com.example.chucknorris.jokes.JokeDTO
import java.util.*

@Entity(tableName = "jokes")
data class JokeEntity(
    @PrimaryKey
    var id: String,
    var icon_url: String,
    var url: String,
    var value: String,
    var date: String
)

fun JokeDTO.toJokeEntity(): JokeEntity {
    return with(this) {
        JokeEntity(
            id = id,
            icon_url = icon_url,
            url = url,
            value = value,
            DateCommons.toISOString(Date())
        )
    }
}
