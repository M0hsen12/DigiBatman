package com.digibatman.di.network


import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {

    @GET("")
    suspend fun getAllCoins(): Response<String>

    @GET("")
    suspend fun getNotifications(): Response<String>


}