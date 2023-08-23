package com.digibatman.di.database.movie

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
class MovieEntity(
    @PrimaryKey
    @ColumnInfo(name = "movieImdbId")
    var movieImdbId: String,
    @ColumnInfo(name = "movieTitle")
    var movieTitle: String,
    @ColumnInfo(name = "moviePoster")
    var moviePoster: String,
    @ColumnInfo(name = "movieType")
    var movieType: String,
    @ColumnInfo(name = "movieYear")
    var movieYear: String,


    )