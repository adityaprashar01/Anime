package com.example.anime.model.repository

import com.example.anime.model.Anime
import com.example.anime.model.api.RetrofitInstance

class ApiRepository {
    suspend fun fetchTopAnime(): List<Anime> {
        val response = RetrofitInstance.api.getTopAnime()
        return response.data.map {
            Anime(
                title = it.node.title,
                rank = it.ranking.rank
            )
        }
    }
}
