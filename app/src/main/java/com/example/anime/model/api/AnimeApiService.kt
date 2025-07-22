package com.example.anime.model.api
import com.example.anime.model.AnimeResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface AnimeApiService {
    @GET("anime/ranking?limit=10")
    suspend fun getTopAnime(): AnimeResponse
}
