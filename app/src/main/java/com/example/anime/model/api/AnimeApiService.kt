package com.example.anime.model.api
import com.example.anime.model.AnimeResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface AnimeApiService {
    @GET("anime/ranking?limit=10")
    @Headers("X-MAL-CLIENT-ID: a8e97fa29f95ada3168ae089d8be965b")
    suspend fun getTopAnime(): AnimeResponse
}
