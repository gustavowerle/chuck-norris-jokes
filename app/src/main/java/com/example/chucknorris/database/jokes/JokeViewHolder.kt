package com.example.chucknorris.database.jokes

import androidx.recyclerview.widget.RecyclerView
import com.example.chucknorris.databinding.ItemViewJokeBinding

class JokeViewHolder(
    private val binding: ItemViewJokeBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun fill(joke: JokeDTO) {
        binding.txtJoke.text = joke.value
    }
}