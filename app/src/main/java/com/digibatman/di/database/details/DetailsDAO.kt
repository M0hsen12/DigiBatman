package com.digibatman.di.database.details

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.digibatman.di.database.detail.DetailsEntity

@Dao
interface DetailsDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addDetails(details: DetailsEntity)

    @Query("SELECT * FROM detail WHERE detailImdbId = :imdbId")
    fun findMovieDetails(imdbId: String): DetailsEntity


}