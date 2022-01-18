package com.etwicaksono.infomovie2.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.etwicaksono.infomovie2.R
import com.etwicaksono.infomovie2.data.source.remote.response.Genre
import java.io.IOException
import kotlin.math.floor

object Helper {

    const val TYPE_MOVIE = "TYPE_MOVIE"
    const val TYPE_TVSHOW = "TYPE_TVSHOW"
    const val API_IMAGE_ENDPOINT = "https://image.tmdb.org/t/p/"
    const val ENDPOINT_POSTER_SIZE_W185 = "w185"
    const val ENDPOINT_POSTER_SIZE_W780 = "w780"

    fun setImageWithGlide(context: Context, imagePath: String, imageView: ImageView) {
        Glide.with(context).clear(imageView)
        Glide.with(context).load(imagePath).into(imageView)
    }

    fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use {
                it.readText()
            }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    fun getRuntime(input: Int): String {
        val hour = floor((input.toDouble() / 60)).toInt()
        val minutes = (input % 60).toString()
        return if (hour > 0) {
            "${hour}h ${minutes}m"
        } else "${minutes}m"
    }

    fun getAccessToken(context: Context): String? {
        val sharedPref = context.getSharedPreferences(
            context.getString(R.string.preference_file_key),
            Context.MODE_PRIVATE
        )
        return sharedPref.getString(context.getString(R.string.saved_request_token), "")
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
}