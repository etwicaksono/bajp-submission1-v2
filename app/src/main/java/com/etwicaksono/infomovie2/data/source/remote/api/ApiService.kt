package com.etwicaksono.infomovie2.data.source.remote.api

import com.etwicaksono.infomovie2.BuildConfig
import com.etwicaksono.infomovie2.data.source.remote.response.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("authentication/token/new")
    fun getRequestToken(): Call<ResponseRequestToken>

    @GET("movie/popular")
    fun getPopularMovie(
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY
    ): Call<ResponseCatalogue<ResponseMovieItem>>

    @GET("genre/movie/list")
    fun getMovieGenres(
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY
    ): Call<List<Genre>>

    @GET("movie/{movie_id}")
    fun getDetailMovie(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY
    ): Call<ResponseDetailMovie>

    @GET("tv/popular")
    fun getPopularTvShow(
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY
    ): Call<ResponseCatalogue<ResponseTvShowItem>>


}