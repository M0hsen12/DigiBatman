package com.digibatman.di.network


import com.digibatman.model.movie.BatmanMovies
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {

    @GET("/?apikey=3e974fca&s=batman")
    suspend fun getBatmanMovies(): Response<BatmanMovies>

    @GET("")
    suspend fun getDetails(): Response<String>


}