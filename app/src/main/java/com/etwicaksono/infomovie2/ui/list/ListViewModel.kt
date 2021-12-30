package com.etwicaksono.infomovie2.ui.list

import androidx.lifecycle.ViewModel
import com.etwicaksono.infomovie2.data.MovieEntity
import com.etwicaksono.infomovie2.utils.DataDummy

class ListViewModel : ViewModel() {

    lateinit var movie: List<MovieEntity>

    fun getAllMovies() {
        movie = DataDummy.getAllMovies()
    }

    fun getAllTvShows() {
        movie = DataDummy.getAllTvShows()
    }


}