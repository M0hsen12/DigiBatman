package com.digibatman.di.network


import com.digibatman.model.details.Details
import com.digibatman.model.movie.BatmanMovies
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

    @GET("/?apikey=3e974fca&s=batman")
    suspend fun getBatmanMovies(): Response<BatmanMovies>

    @GET("/?apikey=3e974fca")
    suspend fun getDetails(@Query("i") imdbId: String): Response<Details>


}