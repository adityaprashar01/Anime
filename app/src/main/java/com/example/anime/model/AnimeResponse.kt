package com.example.anime.model

data class AnimeResponse(
    val data: List<AnimeData>
)

data class AnimeData(
    val node: AnimeNode,
    val ranking: Ranking
)

data class AnimeNode(
    val title: String
)

data class Ranking(
    val rank: Int
)
