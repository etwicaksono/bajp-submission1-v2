package com.etwicaksono.infomovie2.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.etwicaksono.infomovie2.data.CatalogueModel
import com.etwicaksono.infomovie2.data.DetailItemModel
import com.etwicaksono.infomovie2.data.source.remote.RemoteDataSource
import com.etwicaksono.infomovie2.data.source.remote.response.ResponseDetailMovie
import com.etwicaksono.infomovie2.data.source.remote.response.ResponseMovieItem
import com.etwicaksono.infomovie2.data.source.remote.response.ResponseTvShowItem
import com.etwicaksono.infomovie2.utils.Helper.getReleaseYear
import com.etwicaksono.infomovie2.utils.Helper.getRuntime
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class CatalogueRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    CatalogueDataSource {
    override fun getPopularMovies(): LiveData<List<CatalogueModel>> {
        val listMoviesResult = MutableLiveData<List<CatalogueModel>>()
        CoroutineScope(IO).launch {
            remoteDataSource.getPopularMovies(object : RemoteDataSource.LoadMoviesCallback {
                override fun onPopularMoviesReceived(res: List<ResponseMovieItem>) {
                    val movieList = ArrayList<CatalogueModel>()
                    for (res in res) {
                        val movie = CatalogueModel(
                            res.id,
                            "movies",
                            res.releaseDate,
                            getReleaseYear(res.releaseDate, "-"),
                            res.title,
                            res.plot,
                            res.posterPath,
                        )
                        movieList.add(movie)
                    }
                    listMoviesResult.postValue(movieList)
                }
            })
        }
        return listMoviesResult
    }

    override fun getMovieDetail(movieId: Int): LiveData<DetailItemModel> {
        val movieResult = MutableLiveData<DetailItemModel>()
        CoroutineScope(IO).launch {
            remoteDataSource.getMovieDetail(movieId,object:RemoteDataSource.LoadMovieDetailCallback{
                override fun onMoviedetailReceived(res: ResponseDetailMovie) {
                    val movie = DetailItemModel(
                        res.backdropPath,
                        "genres",
                        res.id,
                        res.overview,
                        res.posterPath,
                        res.releaseDate,
                        res.releaseDate?.let { getReleaseYear(it) },
                        res.runtime?.let { getRuntime(it) },
                        res.title,
                        res.voteAverage.toString()
                    )
                    movieResult.postValue(movie)
                }

            })
        }
        return movieResult
    }

    override fun getPopularTvShow(): LiveData<List<CatalogueModel>> {
        val listTvShowResult = MutableLiveData<List<CatalogueModel>>()
        CoroutineScope(IO).launch {
            remoteDataSource.getPopularTvShow(object : RemoteDataSource.LoadTvShowsCallback {
                override fun onPopularTvShowsReceived(res: List<ResponseTvShowItem>) {
                    val tvShowList = ArrayList<CatalogueModel>()
                    for (res in res) {
                        val show = CatalogueModel(
                            res.id,
                            "series",
                            res.releaseDate,
                            getReleaseYear(res.releaseDate, "-"),
                            res.title,
                            res.plot,
                            res.posterPath
                        )
                        tvShowList.add(show)
                    }
                    listTvShowResult.postValue(tvShowList)
                }

            })
        }
        return listTvShowResult
    }

    override fun getTvShowDetail(movieId: Int): LiveData<CatalogueModel> {
        TODO("Not yet implemented")
    }


    companion object {
        @Volatile
        private var instance: CatalogueRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): CatalogueRepository =
            instance ?: synchronized(this) {
                instance ?: CatalogueRepository(remoteDataSource)
            }
    }
}