package com.example.chucknorris

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.chucknorris.jokes.IJokesRepository
import com.example.chucknorris.jokes.JokeDTO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: IJokesRepository
) : ViewModel() {

    private val _joke = MutableLiveData<JokeDTO>()
    val joke: LiveData<JokeDTO> get() = _joke

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> get() = _message

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    val history = Pager(
        PagingConfig(
            pageSize = 10,
            enablePlaceholders = true,
            maxSize = 100
        )
    ) { repository.getAll() }.flow

    init {
        if (_joke.value == null)
            getARandomJoke()
    }

    fun getARandomJoke() {
        _isLoading.value = true
        CoroutineScope(Dispatchers.IO).launch {
            try {
                repository.getARandomJokeFromServer()?.let { joke ->
                    _joke.postValue(joke)
                    repository.save(joke)
                }
            } catch (e: Exception) {
                _message.postValue(e.message)
            } finally {
                _isLoading.postValue(false)
            }
        }
    }
}