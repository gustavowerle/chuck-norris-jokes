package com.example.chucknorris.framework

import java.text.SimpleDateFormat
import java.util.*

class DateCommons {
    companion object {
        fun toISOString(date: Date): String {
            val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.getDefault())
            return sdf.format(date)
        }
    }
}