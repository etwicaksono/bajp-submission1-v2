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

    @GET("movie/{movie_id}")
    fun getDetailMovie(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY
    ): Call<ResponseDetailMovie>

    @GET("tv/popular")
    fun getPopularTvShow(
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY
    ): Call<ResponseCatalogue<ResponseTvShowItem>>

    @GET("tv/{tv_id}")
    fun getDetailTv(
        @Path("tv_id") tvId: Int,
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY
    ): Call<ResponseDetailTv>


}