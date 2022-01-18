package com.etwicaksono.infomovie2.data.source.remote

import com.etwicaksono.infomovie2.data.source.remote.api.ApiConfig
import com.etwicaksono.infomovie2.data.source.remote.response.ResponseDetailMovie
import com.etwicaksono.infomovie2.data.source.remote.response.ResponseDetailTv
import com.etwicaksono.infomovie2.data.source.remote.response.ResponseMovieItem
import com.etwicaksono.infomovie2.data.source.remote.response.ResponseTvShowItem
import retrofit2.await

class RemoteDataSource {

    suspend fun getPopularMovies(callback: LoadMoviesCallback) {
        api.getPopularMovie().await().result.let {
            callback.onPopularMoviesReceived(it)
        }
    }

    interface LoadMoviesCallback {
        fun onPopularMoviesReceived(res: List<ResponseMovieItem>)
    }

    suspend fun getPopularTvShow(callback: LoadTvShowsCallback) {
        api.getPopularTvShow().await().result.let {
            callback.onPopularTvShowsReceived(it)
        }
    }

    interface LoadTvShowsCallback {
        fun onPopularTvShowsReceived(res: List<ResponseTvShowItem>)
    }

    suspend fun getMovieDetail(movieId: Int, callback: LoadMovieDetailCallback) {
        api.getDetailMovie(movieId).await().let {
            callback.onMoviedetailReceived(it)
        }
    }

    interface LoadMovieDetailCallback {
        fun onMoviedetailReceived(res: ResponseDetailMovie)
    }

    suspend fun getTvDetail(tvId: Int, callback: LoadTvDetailCallback) {
        api.getDetailTv(tvId).await().let {
            callback.onTvDetailReceived(it)
        }
    }

    interface LoadTvDetailCallback {
        fun onTvDetailReceived(res: ResponseDetailTv)
    }

    /*suspend fun getMovieGenres(callback: LoadMovieGenredCallback) {
        api.getMovieGenres().await().let {
            callback.onMovieGenresReceived(it)
        }
    }

    interface LoadMovieGenredCallback {
        fun onMovieGenresReceived(genres: List<Genre>)
    }*/

    companion object {
        private val api = ApiConfig.getApiService()
        private val TAG = RemoteDataSource::class.java.simpleName

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) { instance ?: RemoteDataSource() }

    }

}

