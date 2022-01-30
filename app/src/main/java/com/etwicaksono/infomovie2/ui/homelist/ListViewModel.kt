package com.etwicaksono.infomovie2.ui.homelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.etwicaksono.infomovie2.data.CatalogueRepository
import com.etwicaksono.infomovie2.data.source.local.entity.ListEntity
import com.etwicaksono.infomovie2.valueobject.Resource

class ListViewModel(private val repo: CatalogueRepository) : ViewModel() {

    fun getAllMovies(): LiveData<Resource<PagedList<ListEntity>>> = repo.getPopularMovies()

    fun getAllTvShows(): LiveData<Resource<PagedList<ListEntity>>> = repo.getPopularTvShow()
}