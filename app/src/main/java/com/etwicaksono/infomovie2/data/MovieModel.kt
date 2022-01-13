package com.etwicaksono.infomovie2.data


data class MovieModel(
    val id: Int,
    val type:String,
    val backdropPath: String,
    val releaseDate: String,
    val genre: String,
    val title: String,
    val plot: String,
    val posterPath: String,
    val vote: Double,
)