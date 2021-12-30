package com.etwicaksono.infomovie2.data


data class MovieEntity(
     var id: Int?,
     var type: String?,
     var title: String?,
     var year: String?,
     var releaseDate: String?,
     var runtime: String?,
     var genres: String?,
     var director: String?,
     var actors: String?,
     var plot: String?,
     var poster: Int?
)