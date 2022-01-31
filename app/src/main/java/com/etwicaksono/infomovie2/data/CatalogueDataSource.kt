package com.etwicaksono.infomovie2.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import androidx.sqlite.db.SupportSQLiteQuery
import com.etwicaksono.infomovie2.data.source.local.entity.ListEntity
import com.etwicaksono.infomovie2.data.source.local.entity.DetailEntity
import com.etwicaksono.infomovie2.data.source.local.entity.ListWithDetail
import com.etwicaksono.infomovie2.valueobject.Resource

interface CatalogueDataSource {
    fun getPopularMovies(type: String,sort: String): LiveData<Resource<PagedList<ListEntity>>>
    fun getMovieDetail(movieId:Int): LiveData<Resource<DetailEntity>>
    fun getPopularTvShow(type: String,sort: String): LiveData<Resource<PagedList<ListEntity>>>
    fun getTvShowDetail(tvId:Int): LiveData<Resource<DetailEntity>>
    fun getFavoriteMovies():LiveData<PagedList<ListEntity>>
    fun getFavoriteTvShows():LiveData<PagedList<ListEntity>>
    fun setFavorite(catalogue:DetailEntity,state:Boolean)
}