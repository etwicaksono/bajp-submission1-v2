package com.etwicaksono.infomovie2.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id")
    val id: Int,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    @SerializedName("title")
    val title: String,
    @SerializedName("overview")
    val plot: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("vote_average")
    val vote: Double,
)