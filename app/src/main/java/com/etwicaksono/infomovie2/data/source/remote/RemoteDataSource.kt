package com.etwicaksono.infomovie2.data.source.remote

import com.etwicaksono.infomovie2.data.source.remote.api.ApiConfig
import com.etwicaksono.infomovie2.data.source.remote.response.ResponseDetailMovie
import com.etwicaksono.infomovie2.data.source.remote.response.ResponseDetailTv
import com.etwicaksono.infomovie2.data.source.remote.response.ResponseMovieItem
import com.etwicaksono.infomovie2.data.source.remote.response.ResponseTvShowItem
import com.etwicaksono.infomovie2.utils.EspressoIdlingResource.decrement
import com.etwicaksono.infomovie2.utils.EspressoIdlingResource.increment
import retrofit2.await

class RemoteDataSource {

    suspend fun getPopularMovies(callback: LoadMoviesCallback) {
        increment()
        api.getPopularMovie().await().result.let {
            callback.onPopularMoviesReceived(it)
            decrement()
        }
    }

    interface LoadMoviesCallback {
        fun onPopularMoviesReceived(res: List<ResponseMovieItem>)
    }

    suspend fun getPopularTvShow(callback: LoadTvShowsCallback) {
        increment()
        api.getPopularTvShow().await().result.let {
            callback.onPopularTvShowsReceived(it)
            decrement()
        }
    }

    interface LoadTvShowsCallback {
        fun onPopularTvShowsReceived(res: List<ResponseTvShowItem>)
    }

    suspend fun getMovieDetail(movieId: Int, callback: LoadMovieDetailCallback) {
        increment()
        api.getDetailMovie(movieId).await().let {
            callback.onMoviedetailReceived(it)
            decrement()
        }
    }

    interface LoadMovieDetailCallback {
        fun onMoviedetailReceived(res: ResponseDetailMovie)
    }

    suspend fun getTvDetail(tvId: Int, callback: LoadTvDetailCallback) {
        increment()
        api.getDetailTv(tvId).await().let {
            callback.onTvDetailReceived(it)
            decrement()
        }
    }

    interface LoadTvDetailCallback {
        fun onTvDetailReceived(res: ResponseDetailTv)
    }


    companion object {
        private val api = ApiConfig.getApiService()
        private val TAG = RemoteDataSource::class.java.simpleName

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) { instance ?: RemoteDataSource() }

    }

}

