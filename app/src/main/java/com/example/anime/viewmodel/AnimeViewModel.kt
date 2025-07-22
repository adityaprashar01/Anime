package com.example.anime.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anime.model.Anime
import com.example.anime.model.repository.ApiRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AnimeViewModel : ViewModel() {
    private val repository = ApiRepository()

    private val _animeList = MutableStateFlow<List<Anime>>(emptyList())
    val animeList: StateFlow<List<Anime>> = _animeList

    private val _error = MutableStateFlow<String>("")
    val error: StateFlow<String> = _error

    init {
        viewModelScope.launch {
            try {
                val result = repository.fetchTopAnime()
                _animeList.value = result
            } catch (e: Exception) {
                _error.value = "Network Error: ${e.message}"
            }
        }
    }
}
