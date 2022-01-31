package com.etwicaksono.infomovie2.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ResponseMovieItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("overview")
    val plot: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("vote_average")
    val vote: Double = 0.0,
)