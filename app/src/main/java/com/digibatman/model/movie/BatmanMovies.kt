package com.digibatman.model.movie


import com.google.gson.annotations.SerializedName

data class BatmanMovies(
    @SerializedName("Response")
    val response: String?,
    @SerializedName("Search")
    val search: List<Search?>,
    @SerializedName("totalResults")
    val totalResults: String?
)