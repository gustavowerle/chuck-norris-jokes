package com.example.chucknorris.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chucknorris.database.jokes.IJokesRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: IJokesRepository
) : ViewModel() {

    val history = repository.jokes

    val joke = repository.newJoke

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> get() = _message

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    init {
        if (joke.value == null) {
            getARandomJoke()
        }
        getJokesHistory()
    }

    private fun getJokesHistory() {
        viewModelScope.launch {
            repository.getAll()
        }
    }

    fun getARandomJoke() {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                repository.getARandomJokeFromServer()
            } catch (e: Exception) {
                _message.postValue(e.message)
            } finally {
                _isLoading.postValue(false)
            }
        }
    }
}