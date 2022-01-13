package com.etwicaksono.infomovie2.data.source

import androidx.lifecycle.LiveData
import com.etwicaksono.infomovie2.data.MovieEntity

interface MovieDataSource {
    fun getPopularMovies(): LiveData<List<MovieEntity>>
    fun getMovieDetail(): LiveData<MovieEntity>
    fun getPopularTvShow(): LiveData<List<MovieEntity>>
    fun getTvShowDetail(): LiveData<MovieEntity>
}