package com.digibatman.model.details


import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("Source")
    val source: String? = null,
    @SerializedName("Value")
    val value: String? = null
)