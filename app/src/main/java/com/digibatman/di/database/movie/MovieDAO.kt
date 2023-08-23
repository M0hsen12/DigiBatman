package com.digibatman.di.database.movie

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovie(movie: MovieEntity)

    @Query("SELECT * FROM movies WHERE  movieImdbId= :imdbID")
    fun findMovie(imdbID: String): MovieEntity

    @Query("SELECT * FROM movies")
    fun getAllMovies(): List<MovieEntity>


}