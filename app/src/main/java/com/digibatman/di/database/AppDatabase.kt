package com.digibatman.di.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.digibatman.di.database.detail.DetailsEntity
import com.digibatman.di.database.details.DetailsDAO
import com.digibatman.di.database.movie.MovieDAO
import com.digibatman.di.database.movie.MovieEntity

@Database(entities = [MovieEntity::class, DetailsEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun MovieDAO(): MovieDAO
    abstract fun detailsDAO(): DetailsDAO

}