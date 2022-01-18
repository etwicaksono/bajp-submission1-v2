package com.etwicaksono.infomovie2.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.etwicaksono.infomovie2.data.DetailItemModel
import com.etwicaksono.infomovie2.data.source.CatalogueRepository

class DetailViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    fun getMovieDetail(movieId: Int): LiveData<DetailItemModel> =
        catalogueRepository.getMovieDetail(movieId)

    fun getTvDetail(tvId: Int): LiveData<DetailItemModel> =
        catalogueRepository.getTvShowDetail(tvId)
}