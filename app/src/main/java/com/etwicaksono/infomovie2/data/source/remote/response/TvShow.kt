package com.etwicaksono.infomovie2.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TvShow(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("first_air_date")
    val releaseDate: String?,
    @SerializedName("genre_ids")
    val genreIds: List<Int>?,
    @SerializedName("name")
    val title: String?,
    @SerializedName("overview")
    val plot: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("vote_average")
    val vote: Double?,
)