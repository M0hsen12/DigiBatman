package com.digibatman.di.database.details

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DetailsDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addDetails(details: DetailsEntity)

    @Query("SELECT * FROM details WHERE  detailsImdbId= :imdbId")
    fun findMovieDetails(imdbId: String): DetailsEntity


}