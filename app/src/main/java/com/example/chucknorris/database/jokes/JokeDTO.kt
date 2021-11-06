package com.example.chucknorris.database.jokes

data class JokeDTO(
    var icon_url: String,
    var id: String,
    var url: String,
    var value: String,
    var date: String,
)