package com.etwicaksono.infomovie2.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.etwicaksono.infomovie2.data.source.local.entity.DetailEntity
import com.etwicaksono.infomovie2.data.CatalogueRepository

class DetailViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    fun getMovieDetail(movieId: Int): LiveData<DetailEntity> =
        catalogueRepository.getMovieDetail(movieId)

    fun getTvDetail(tvId: Int): LiveData<DetailEntity> =
        catalogueRepository.getTvShowDetail(tvId)
}