package com.etwicaksono.infomovie2.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.etwicaksono.infomovie2.data.MovieModel
import com.etwicaksono.infomovie2.data.source.remote.RemoteDataSource
import com.etwicaksono.infomovie2.data.source.remote.response.Movie
import com.etwicaksono.infomovie2.utils.getReleaseYear
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MovieRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    MovieDataSource {
    override fun getPopularMovies(): LiveData<List<MovieModel>> {
        val listMoviesResult = MutableLiveData<List<MovieModel>>()
        CoroutineScope(IO).launch {
            remoteDataSource.getPopularMovies(object : RemoteDataSource.LoadMoviesCallback {
                override fun onPopularMoviesReceived(movieResponse: List<Movie>) {
                    val movieList = ArrayList<MovieModel>()
                    for(response in movieResponse){
                        val movie=MovieModel(
                            response.id,
                            "movies",
                            response.title,
                            response.releaseDate,
                            getReleaseYear(response.releaseDate,"-"),

                        )
                    }
                }
            })
        }
    }

    override fun getMovieDetail(): LiveData<MovieModel> {
        TODO("Not yet implemented")
    }

    override fun getPopularTvShow(): LiveData<List<MovieModel>> {
        TODO("Not yet implemented")
    }

    override fun getTvShowDetail(): LiveData<MovieModel> {
        TODO("Not yet implemented")
    }

    companion object {
        @Volatile
        private var instance: MovieRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): MovieRepository =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(remoteDataSource)
            }
    }
}