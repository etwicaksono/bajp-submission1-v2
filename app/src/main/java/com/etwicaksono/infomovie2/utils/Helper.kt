package com.etwicaksono.infomovie2.utils

import android.content.Context
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.etwicaksono.infomovie2.R
import com.etwicaksono.infomovie2.data.source.remote.response.Genre
import kotlin.math.floor

object Helper {

    const val TYPE_MOVIE = "movie"
    const val TYPE_TV = "tv"
    val TAB_TITLES = listOf(TYPE_MOVIE, TYPE_TV)
    const val API_IMAGE_ENDPOINT = "https://image.tmdb.org/t/p/"
    const val ENDPOINT_POSTER_SIZE_W185 = "w185"
    const val ENDPOINT_POSTER_SIZE_W780 = "w780"

    fun setImageWithGlide(context: Context, imagePath: String, imageView: ImageView) {
        Glide.with(context).clear(imageView)
        Glide.with(context)
            .load(imagePath)
            .apply(RequestOptions.timeoutOf(5000))
            .error(R.drawable.ic_broken_image)
            .into(imageView)
    }

    fun getRuntime(input: Int): String {
        val hour = floor((input.toDouble() / 60)).toInt()
        val minutes = (input % 60).toString()
        return if (hour > 0) {
            "${hour}h ${minutes}m"
        } else "${minutes}m"
    }

    fun getReleaseYear(releaseDate: String, separator: String = "/"): String {
        val arr = releaseDate.split(separator).toTypedArray()
        return arr[0]
    }

    fun getGenres(genres: List<Genre>?): String {
        val output = ArrayList<String>()
        if (genres != null) {
            for (genre in genres) {
                genre.name?.let { output.add(it) }
            }
        }

        return output.joinToString(", ")
    }

    fun logger(data: Any) {
        Log.d("LOGGER", data.toString())
    }
}