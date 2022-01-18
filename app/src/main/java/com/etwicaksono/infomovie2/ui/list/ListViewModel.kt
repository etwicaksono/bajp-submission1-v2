package com.etwicaksono.infomovie2.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.etwicaksono.infomovie2.data.CatalogueModel
import com.etwicaksono.infomovie2.data.source.CatalogueRepository

class ListViewModel(private val repo: CatalogueRepository) : ViewModel() {

    fun getAllMovies(): LiveData<List<CatalogueModel>> = repo.getPopularMovies()

    fun getAllTvShows(): LiveData<List<CatalogueModel>> = repo.getPopularTvShow()


}