package com.etwicaksono.infomovie2.utils

import com.etwicaksono.infomovie2.R
import com.etwicaksono.infomovie2.data.CatalogueModel

object DataDummy {
    fun getAllMovies(): List<CatalogueModel> {
        val movies = ArrayList<CatalogueModel>()
        return movies

    }

    fun getAllTvShows(): List<CatalogueModel> {
        val series = ArrayList<CatalogueModel>()

        return series
    }
}