package com.etwicaksono.infomovie2.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.etwicaksono.infomovie2.data.MovieModel
import com.etwicaksono.infomovie2.data.source.MovieRepository

class ListViewModel(private val repo: MovieRepository) : ViewModel() {

    fun getAllMovies(): LiveData<List<MovieModel>> = repo.getPopularMovies()

    fun getAllTvShows(): LiveData<List<MovieModel>> = repo.getPopularTvShow()


}