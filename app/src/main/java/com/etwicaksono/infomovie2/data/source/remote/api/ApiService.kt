package com.etwicaksono.infomovie2.data.source.remote.api

import com.etwicaksono.infomovie2.BuildConfig
import com.etwicaksono.infomovie2.data.source.remote.response.Genre
import com.etwicaksono.infomovie2.data.source.remote.response.ListResponse
import com.etwicaksono.infomovie2.data.source.remote.response.Movie
import com.etwicaksono.infomovie2.data.source.remote.response.ResponseRequestToken
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("authentication/token/new")
    fun getRequestToken(): Call<ResponseRequestToken>

    @GET("movie/popular")
    fun getPopularMovie(
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY
    ): Call<ListResponse<Movie>>

    @GET("genre/movie/list")
    fun getMovieGenres(@Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY): Call<List<Genre>>


}