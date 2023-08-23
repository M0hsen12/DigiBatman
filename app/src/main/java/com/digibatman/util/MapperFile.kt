package com.digibatman.util

import com.digibatman.di.database.detail.DetailsEntity
import com.digibatman.di.database.movie.MovieEntity
import com.digibatman.model.details.Details
import com.digibatman.model.movie.Search

fun batmanMoviesToEntity(movies: Search): MovieEntity {
    return MovieEntity(
        movieImdbId = movies.imdbID ?: "",
        movieTitle = movies.title ?: "",
        moviePoster = movies.poster ?: "",
        movieType = movies.type ?: "",
        movieYear = movies.year ?: ""
    )
}

fun entityToBatmanMovies(movieEntity: MovieEntity): Search {
    return Search(
        imdbID = movieEntity.movieImdbId,
        poster = movieEntity.moviePoster,
        title = movieEntity.movieTitle,
        type = movieEntity.movieType,
        year = movieEntity.movieYear
    )
}

fun movieDetailToEntity(details: Details): DetailsEntity {
    return DetailsEntity(
        detailImdbId = details.imdbID ?: "",
        detailTitle = details.title ?: "",
        detailPoster = details.poster ?: "",
        detailLang = details.language ?: "",
        detailType = details.type ?: "",
        detailPlot = details.plot ?: "",
        detailRated = details.rated ?: "",
        detailRuntime = details.runtime ?: "",
        detailYear = details.year ?: ""
    )
}

fun detailEntityToDetails(details: DetailsEntity): Details {
    return Details(
        imdbID = details.detailImdbId ?: "",
        title = details.detailTitle ?: "",
        poster = details.detailPoster ?: "",
        language = details.detailLang ?: "",
        type = details.detailType ?: "",
        plot = details.detailPlot ?: "",
        rated = details.detailRated ?: "",
        runtime = details.detailRuntime ?: "",
        year = details.detailYear ?: ""
    )
}

