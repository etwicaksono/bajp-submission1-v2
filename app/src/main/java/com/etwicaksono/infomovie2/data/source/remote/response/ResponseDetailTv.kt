package com.etwicaksono.infomovie2.data.source.remote.response


import com.google.gson.annotations.SerializedName

data class ResponseDetailTv(
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("episode_run_time")
    val runtime: List<Int>?,
    @SerializedName("first_air_date")
    val releaseDate: String?,
    @SerializedName("genres")
    val genres: List<Genre>?,
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val title: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("vote_average")
    val voteAverage: Double?,
)