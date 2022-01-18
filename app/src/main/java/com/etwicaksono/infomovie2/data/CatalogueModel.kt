package com.etwicaksono.infomovie2.data


data class CatalogueModel(
    val id: Int,
    val type:String,
    val backdropPath: String,
    val releaseDate: String,
    val year: String,
    val genre: String,
    val title: String,
    val plot: String,
    val posterPath: String,
    val vote: Double,
)