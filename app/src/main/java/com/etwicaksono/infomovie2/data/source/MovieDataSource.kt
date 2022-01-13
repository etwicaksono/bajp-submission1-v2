package com.etwicaksono.infomovie2.data.source

import androidx.lifecycle.LiveData
import com.etwicaksono.infomovie2.data.MovieModel

interface MovieDataSource {
    fun getPopularMovies(): LiveData<List<MovieModel>>
    fun getMovieDetail(): LiveData<MovieModel>
    fun getPopularTvShow(): LiveData<List<MovieModel>>
    fun getTvShowDetail(): LiveData<MovieModel>
}