package com.etwicaksono.infomovie2.data.source

import androidx.lifecycle.LiveData
import com.etwicaksono.infomovie2.data.CatalogueModel

interface MovieDataSource {
    fun getPopularMovies(): LiveData<List<CatalogueModel>>
    fun getMovieDetail(): LiveData<CatalogueModel>
    fun getPopularTvShow(): LiveData<List<CatalogueModel>>
    fun getTvShowDetail(): LiveData<CatalogueModel>
}