package com.etwicaksono.infomovie2.ui.detail

import android.content.Context
import androidx.lifecycle.ViewModel
import com.etwicaksono.infomovie2.data.MovieEntity
import com.etwicaksono.infomovie2.utils.DataDummy

class DetailViewModel : ViewModel() {

    private var itemId: Int = 1
    private lateinit var type: String
    lateinit var item: MovieEntity

    fun setSelectedItem(type: String?, id: Int?) {
        if (type != null) {
            this.type = type
        } else {
            this.type = "movies"
        }
        if (id != null) {
            this.itemId = id
        }
    }

    fun getItem(context: Context) {
        val result =
            if (type == "movies") DataDummy.getAllMovies() else DataDummy.getAllTvShows()

        for (res in result) {
            if (itemId == res.id) {
                item = res
            }
        }
    }
}