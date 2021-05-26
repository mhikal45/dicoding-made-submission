package com.wal.winteranimelist2021.core.utils

import com.wal.winteranimelist2021.core.data.source.local.entity.AnimeEntity
import com.wal.winteranimelist2021.core.data.source.remote.response.AnimeItem
import com.wal.winteranimelist2021.core.domain.model.Anime
import java.lang.StringBuilder

object DataMapper {

    fun mapResponseToEntities (input : List<AnimeItem>) : List<AnimeEntity> {
        val animeList = ArrayList<AnimeEntity>()
        input.map { anime ->
            val genre = StringBuilder().append("")

            for (i in anime.genres.indices) {
                if (i < anime.genres.size-1) {
                    genre.append("${anime.genres[i].name},")
                } else {
                    genre.append(anime.genres[i].name)
                }
            }

            val item = AnimeEntity(
                id = anime.malId,
                synopsis = anime.synopsis,
                source = anime.source,
                title = anime.title,
                score = anime.score,
                startAiring = anime.airingStart,
                episode = anime.episodes,
                poster = anime.imageUrl,
                favorite = false,
                genres = genre.toString()
            )
            animeList.add(item)
        }
        return animeList
    }

    fun mapEntitiesToDomain(input: List<AnimeEntity>): List<Anime> =
        input.map {
            Anime(
                id = it.id,
                synopsis = it.synopsis,
                title = it.title,
                source = it.source,
                startAiring = it.startAiring,
                score = it.score,
                episode = it.episode,
                poster = it.poster,
                genres = it.genres,
                favorite = it.favorite
            )
        }
    fun mapDomainToEntity(input: Anime) =
        AnimeEntity(
            id = input.id,
            title = input.title,
            synopsis = input.synopsis,
            source = input.source,
            startAiring = input.startAiring,
            score = input.score,
            episode = input.episode,
            poster = input.poster,
            genres = input.genres,
            favorite = input.favorite
        )
}