package com.digibatman.util

import com.digibatman.di.database.MovieEntity
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

