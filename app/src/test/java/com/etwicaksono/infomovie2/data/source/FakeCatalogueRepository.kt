package com.etwicaksono.infomovie2.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.etwicaksono.infomovie2.data.CatalogueModel
import com.etwicaksono.infomovie2.data.DetailItemModel
import com.etwicaksono.infomovie2.data.source.remote.RemoteDataSource
import com.etwicaksono.infomovie2.data.source.remote.response.ResponseDetailMovie
import com.etwicaksono.infomovie2.data.source.remote.response.ResponseDetailTv
import com.etwicaksono.infomovie2.data.source.remote.response.ResponseMovieItem
import com.etwicaksono.infomovie2.data.source.remote.response.ResponseTvShowItem
import com.etwicaksono.infomovie2.utils.Helper.TYPE_MOVIE
import com.etwicaksono.infomovie2.utils.Helper.TYPE_TVSHOW
import com.etwicaksono.infomovie2.utils.Helper.getGenres
import com.etwicaksono.infomovie2.utils.Helper.getReleaseYear
import com.etwicaksono.infomovie2.utils.Helper.getRuntime
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class FakeCatalogueRepository(private val remoteDataSource: RemoteDataSource) :
    CatalogueDataSource {
    override fun getPopularMovies(): LiveData<List<CatalogueModel>> {
        val listMoviesResult = MutableLiveData<List<CatalogueModel>>()
        CoroutineScope(IO).launch {
            remoteDataSource.getPopularMovies(object : RemoteDataSource.LoadMoviesCallback {
                override fun onPopularMoviesReceived(res: List<ResponseMovieItem>) {
                    val movieList = ArrayList<CatalogueModel>()
                    for (r in res) {
                        val movie = CatalogueModel(
                            r.id,
                            TYPE_MOVIE,
                            r.releaseDate,
                            getReleaseYear(r.releaseDate, "-"),
                            r.title,
                            r.plot,
                            r.posterPath,
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
                        getGenres(res.genres),
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
                            TYPE_TVSHOW,
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

    override fun getTvShowDetail(tvId: Int): LiveData<DetailItemModel> {
        val tvResult = MutableLiveData<DetailItemModel>()
        CoroutineScope(IO).launch {
            remoteDataSource.getTvDetail(tvId,object :RemoteDataSource.LoadTvDetailCallback{
                override fun onTvDetailReceived(res: ResponseDetailTv) {
                    val tv = DetailItemModel(
                        res.backdropPath,
                        getGenres(res.genres),
                        res.id,
                        res.overview,
                        res.posterPath,
                        res.releaseDate,
                        res.releaseDate?.let { getReleaseYear(it) },
                        res.runtime?.get(0)?.let { getRuntime(it) },
                        res.title,
                        res.voteAverage.toString()
                    )
                    tvResult.postValue(tv)
                }

            })
        }
        return tvResult
    }

}