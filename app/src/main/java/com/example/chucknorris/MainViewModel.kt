package com.example.chucknorris

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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

    fun getARandomJoke() {
        _isLoading.value = true
        CoroutineScope(Dispatchers.IO).launch {
            try {
                repository.getARandomJokeFromServer()?.let { joke ->
                    _joke.postValue(joke)
                }
            } catch (e: Exception) {
                _message.postValue(e.message)
            } finally {
                _isLoading.postValue(false)
            }
        }
    }
}