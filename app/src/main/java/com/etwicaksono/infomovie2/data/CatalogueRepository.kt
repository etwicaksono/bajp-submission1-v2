package com.etwicaksono.infomovie2.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.etwicaksono.infomovie2.data.source.local.LocalDataSource
import com.etwicaksono.infomovie2.data.source.local.entity.DetailEntity
import com.etwicaksono.infomovie2.data.source.local.entity.ListEntity
import com.etwicaksono.infomovie2.data.source.local.entity.ListWithDetail
import com.etwicaksono.infomovie2.data.source.remote.ApiResponse
import com.etwicaksono.infomovie2.data.source.remote.RemoteDataSource
import com.etwicaksono.infomovie2.data.source.remote.response.ResponseDetailMovie
import com.etwicaksono.infomovie2.data.source.remote.response.ResponseDetailTv
import com.etwicaksono.infomovie2.data.source.remote.response.ResponseMovieItem
import com.etwicaksono.infomovie2.data.source.remote.response.ResponseTvShowItem
import com.etwicaksono.infomovie2.utils.AppExecutors
import com.etwicaksono.infomovie2.utils.Helper.TYPE_MOVIE
import com.etwicaksono.infomovie2.utils.Helper.TYPE_TV
import com.etwicaksono.infomovie2.utils.Helper.getGenres
import com.etwicaksono.infomovie2.utils.Helper.getReleaseYear
import com.etwicaksono.infomovie2.utils.Helper.getRuntime
import com.etwicaksono.infomovie2.valueobject.Resource

class CatalogueRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) :
    CatalogueDataSource {
    override fun getPopularMovies(): LiveData<Resource<PagedList<ListEntity>>> {
        return object :
            NetworkBoundResource<PagedList<ListEntity>, List<ResponseMovieItem>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<ListEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()

                return LivePagedListBuilder(localDataSource.getMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<ListEntity>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<ResponseMovieItem>>> {
                return remoteDataSource.getPopularMovies()
            }

            override fun saveCallResult(data: List<ResponseMovieItem>) {
                val movieList = ArrayList<ListEntity>()
                for (response in data) {
                    val movie = ListEntity(
                        id = response.id,
                        type = TYPE_MOVIE,
                        releaseDate = response.releaseDate,
                        year = getReleaseYear(response.releaseDate, "-"),
                        title = response.title,
                        plot = response.plot,
                        posterPath = response.posterPath,
                        favorite = false,
                    )
                    movieList.add(movie)
                }
                localDataSource.insertCatalogues(movieList)
            }

        }.asLiveData()
    }

    override fun getMovieDetail(movieId: Int): LiveData<Resource<DetailEntity>> {
        return object : NetworkBoundResource<DetailEntity, ResponseDetailMovie>(appExecutors) {
            override fun loadFromDB(): LiveData<DetailEntity> {
                return localDataSource.getDetailCatalogue(movieId)
            }

            override fun shouldFetch(data: DetailEntity?): Boolean {
                return data == null
            }

            override fun createCall(): LiveData<ApiResponse<ResponseDetailMovie>> {
                return remoteDataSource.getMovieDetail(movieId)
            }

            override fun saveCallResult(data: ResponseDetailMovie) {
                val movie = DetailEntity(
                    id = data.id,
                    backdropPath = data.backdropPath,
                    genres = getGenres(data.genres),
                    overview = data.overview,
                    posterPath = data.posterPath,
                    releaseDate = data.releaseDate,
                    year = data.releaseDate?.let { getReleaseYear(it) },
                    runtime = data.runtime?.let { getRuntime(it) },
                    title = data.title,
                    voteAverage = data.voteAverage.toString(),
                    favorite = false
                )
                localDataSource.insertDetailCatalogue(movie)
            }
        }.asLiveData()
    }

    override fun getPopularTvShow(): LiveData<Resource<PagedList<ListEntity>>> {
        return object :
            NetworkBoundResource<PagedList<ListEntity>, List<ResponseTvShowItem>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<ListEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()

                return LivePagedListBuilder(localDataSource.getTvShow(), config).build()
            }

            override fun shouldFetch(data: PagedList<ListEntity>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<ResponseTvShowItem>>> {
                return remoteDataSource.getPopularTvShow()
            }

            override fun saveCallResult(data: List<ResponseTvShowItem>) {
                val tvList = ArrayList<ListEntity>()
                for (response in data) {
                    val tv = ListEntity(
                        id = response.id,
                        type = TYPE_TV,
                        releaseDate = response.releaseDate,
                        year = getReleaseYear(response.releaseDate, "-"),
                        title = response.title,
                        plot = response.plot,
                        posterPath = response.posterPath,
                        favorite = false,
                    )
                    tvList.add(tv)
                }
                localDataSource.insertCatalogues(tvList)
            }

        }.asLiveData()
    }

    override fun getTvShowDetail(tvId: Int): LiveData<Resource<DetailEntity>> {
        return object : NetworkBoundResource<DetailEntity, ResponseDetailTv>(appExecutors) {
            override fun loadFromDB(): LiveData<DetailEntity> {
                return localDataSource.getDetailCatalogue(tvId)
            }

            override fun shouldFetch(data: DetailEntity?): Boolean {
                return data == null
            }

            override fun createCall(): LiveData<ApiResponse<ResponseDetailTv>> {
                return remoteDataSource.getTvDetail(tvId)
            }

            override fun saveCallResult(data: ResponseDetailTv) {
                val movie = DetailEntity(
                    id = data.id,
                    backdropPath = data.backdropPath,
                    genres = getGenres(data.genres),
                    overview = data.overview,
                    posterPath = data.posterPath,
                    releaseDate = data.releaseDate,
                    year = data.releaseDate?.let { getReleaseYear(it) },
                    runtime = data.runtime?.let { getRuntime(it[0]) },
                    title = data.title,
                    voteAverage = data.voteAverage.toString(),
                    favorite = false
                )
                localDataSource.insertDetailCatalogue(movie)
            }
        }.asLiveData()
    }

    override fun getFavoriteMovies(): LiveData<PagedList<ListEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovies(), config).build()
    }

    override fun getFavoriteTvShows(): LiveData<PagedList<ListEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteTvShows(), config).build()
    }

    override fun setFavorite(catalogue: ListEntity, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setFavorite(catalogue, state) }
    }


    companion object {
        @Volatile
        private var instance: CatalogueRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): CatalogueRepository =
            instance ?: synchronized(this) {
                instance ?: CatalogueRepository(
                    remoteData,
                    localData,
                    appExecutors
                ).apply { instance = this }
            }
    }
}