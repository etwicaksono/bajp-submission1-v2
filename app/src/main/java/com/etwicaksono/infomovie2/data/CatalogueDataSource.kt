package com.etwicaksono.infomovie2.data

import androidx.lifecycle.LiveData
import com.etwicaksono.infomovie2.data.source.local.entity.ListEntity
import com.etwicaksono.infomovie2.data.source.local.entity.DetailEntity

interface CatalogueDataSource {
    fun getPopularMovies(): LiveData<List<ListEntity>>
    fun getMovieDetail(movieId:Int): LiveData<DetailEntity>
    fun getPopularTvShow(): LiveData<List<ListEntity>>
    fun getTvShowDetail(tvId:Int): LiveData<DetailEntity>
}