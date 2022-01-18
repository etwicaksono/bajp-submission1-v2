package com.etwicaksono.infomovie2.data.source

import androidx.lifecycle.LiveData
import com.etwicaksono.infomovie2.data.CatalogueModel
import com.etwicaksono.infomovie2.data.DetailItemModel
import com.etwicaksono.infomovie2.data.source.remote.response.ResponseDetailMovie

interface CatalogueDataSource {
    fun getPopularMovies(): LiveData<List<CatalogueModel>>
    fun getMovieDetail(movieId:Int): LiveData<DetailItemModel>
    fun getPopularTvShow(): LiveData<List<CatalogueModel>>
    fun getTvShowDetail(movieId:Int): LiveData<CatalogueModel>
}