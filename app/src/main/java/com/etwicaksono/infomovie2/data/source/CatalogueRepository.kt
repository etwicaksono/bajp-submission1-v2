package com.etwicaksono.infomovie2.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.etwicaksono.infomovie2.data.CatalogueModel
import com.etwicaksono.infomovie2.data.source.remote.RemoteDataSource
import com.etwicaksono.infomovie2.data.source.remote.response.MovieItem
import com.etwicaksono.infomovie2.utils.Helper.getReleaseYear
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class CatalogueRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    CatalogueDataSource {
    override fun getPopularMovies(): LiveData<List<CatalogueModel>> {
        val listMoviesResult = MutableLiveData<List<CatalogueModel>>()
        CoroutineScope(IO).launch {
            remoteDataSource.getPopularMovies(object : RemoteDataSource.LoadMoviesCallback {
                override fun onPopularMoviesReceived(movieItemResponse: List<MovieItem>) {
                    val movieList = ArrayList<CatalogueModel>()
                    for (response in movieItemResponse) {
                        val movie = CatalogueModel(
                            response.id,
                            "movies",
                            response.title,
                            response.releaseDate,
                            getReleaseYear(response.releaseDate, "-"),
                            response.title,
                            response.plot,
                            response.posterPath,
                        )
                        movieList.add(movie)
                    }
                    listMoviesResult.postValue(movieList)
                }
            })
        }
        return listMoviesResult
    }

   /* override fun getMovieDetail(): LiveData<CatalogueModel> {
        val movieResult=MutableLiveData<CatalogueModel>()
        CoroutineScope(IO).launch {
            remoteDataSource.get
        }
    }*/

    override fun getPopularTvShow(): LiveData<List<CatalogueModel>> {
        TODO("Not yet implemented")
    }

  /*  override fun getTvShowDetail(): LiveData<CatalogueModel> {
        TODO("Not yet implemented")
    }*/

    companion object {
        @Volatile
        private var instance: CatalogueRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): CatalogueRepository =
            instance ?: synchronized(this) {
                instance ?: CatalogueRepository(remoteDataSource)
            }
    }
}