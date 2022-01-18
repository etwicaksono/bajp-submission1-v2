package com.etwicaksono.infomovie2.data.source.remote.response


import com.google.gson.annotations.SerializedName

data class ResponseCatalogue<T>(
    @SerializedName("results")
    val result: List<T>
)