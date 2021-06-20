package com.example.chucknorris.jokes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.chucknorris.databinding.ItemViewJokeBinding
import com.google.gson.Gson

class JokesAdapter : PagingDataAdapter<JokeDTO, JokeViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object :
            DiffUtil.ItemCallback<JokeDTO>() {
            override fun areItemsTheSame(oldItem: JokeDTO, newItem: JokeDTO): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: JokeDTO, newItem: JokeDTO): Boolean {
                return Gson().toJson(oldItem) == Gson().toJson(newItem)
            }
        }
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        val joke: JokeDTO? = getItem(position)
        if (joke != null)
            holder.fill(joke)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val binding =
            ItemViewJokeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JokeViewHolder(binding)
    }

}