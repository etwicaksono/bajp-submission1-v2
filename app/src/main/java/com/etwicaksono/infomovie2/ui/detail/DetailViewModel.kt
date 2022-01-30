package com.etwicaksono.infomovie2.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.etwicaksono.infomovie2.data.CatalogueRepository
import com.etwicaksono.infomovie2.data.source.local.entity.DetailEntity
import com.etwicaksono.infomovie2.data.source.local.entity.ListEntity
import com.etwicaksono.infomovie2.data.source.local.entity.ListWithDetail
import com.etwicaksono.infomovie2.valueobject.Resource

class DetailViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    fun getMovieDetail(movieId: Int): LiveData<Resource<DetailEntity>> =
        catalogueRepository.getMovieDetail(movieId)

    fun getTvDetail(tvId: Int): LiveData<Resource<DetailEntity>> =
        catalogueRepository.getTvShowDetail(tvId)

    fun setFavorite(catalogue: ListEntity, newState: Boolean) =
        catalogueRepository.setFavorite(catalogue, newState)
}