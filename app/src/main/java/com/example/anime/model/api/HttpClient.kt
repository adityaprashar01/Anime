package com.example.anime.model.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object HttpClient {

    private val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(AuthTokenInterceptor())
        .addInterceptor(httpLoggingInterceptor)
        .build()
}
