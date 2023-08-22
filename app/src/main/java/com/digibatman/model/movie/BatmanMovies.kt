package com.digibatman.model.movie


import com.google.gson.annotations.SerializedName

data class BatmanMovies(
    @SerializedName("Response")
    val response: String? = null,
    @SerializedName("Search")
    val search: List<Search?>? = null,
    @SerializedName("totalResults")
    val totalResults: String? = null
)