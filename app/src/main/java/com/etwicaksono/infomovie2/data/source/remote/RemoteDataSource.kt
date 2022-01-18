package com.etwicaksono.infomovie2.data.source.remote

import com.etwicaksono.infomovie2.data.source.remote.api.ApiConfig
import com.etwicaksono.infomovie2.data.source.remote.response.Genre
import com.etwicaksono.infomovie2.data.source.remote.response.MovieItem
import retrofit2.await

class RemoteDataSource {

    suspend fun getPopularMovies(callback: LoadMoviesCallback) {
        api.getPopularMovie().await().result.let {
            callback.onPopularMoviesReceived(it)
        }
    }

    interface LoadMoviesCallback {
        fun onPopularMoviesReceived(movieItemResponse: List<MovieItem>)
    }

    /*fun getMovieDetail(movieId:Int,callback:LoadMovieDetailCallback){
        api.get
    }

    interface LoadMovieDetailCallback {
        fun onMoviedetailReceived(movieItemResponse:MovieItem)
    }

    suspend fun getMovieGenres(callback: LoadMovieGenredCallback) {
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

