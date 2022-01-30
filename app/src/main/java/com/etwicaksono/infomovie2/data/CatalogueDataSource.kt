package com.etwicaksono.infomovie2.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.etwicaksono.infomovie2.data.source.local.entity.ListEntity
import com.etwicaksono.infomovie2.data.source.local.entity.DetailEntity
import com.etwicaksono.infomovie2.data.source.local.entity.ListWithDetail
import com.etwicaksono.infomovie2.valueobject.Resource

interface CatalogueDataSource {
    fun getPopularMovies(): LiveData<Resource<PagedList<ListEntity>>>
    fun getMovieDetail(movieId:Int): LiveData<Resource<ListWithDetail>>
    fun getPopularTvShow(): LiveData<Resource<PagedList<ListEntity>>>
    fun getTvShowDetail(tvId:Int): LiveData<Resource<ListWithDetail>>
    fun getFavoriteMovies():LiveData<PagedList<ListEntity>>
    fun getFavoriteTvShows():LiveData<PagedList<ListEntity>>
    fun setFavorite(catalogue:ListEntity,state:Boolean)
}