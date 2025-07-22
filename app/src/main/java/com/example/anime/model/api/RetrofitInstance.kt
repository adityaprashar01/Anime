package com.example.anime.model.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api: AnimeApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.myanimelist.net/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AnimeApiService::class.java)
    }
}