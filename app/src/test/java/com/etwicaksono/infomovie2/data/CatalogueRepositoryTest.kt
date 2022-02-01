package com.etwicaksono.infomovie2.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.etwicaksono.infomovie2.data.source.local.LocalDataSource
import com.etwicaksono.infomovie2.data.source.remote.RemoteDataSource
import com.etwicaksono.infomovie2.utils.AppExecutors
import com.etwicaksono.infomovie2.utils.DataDummy
import org.junit.Rule
import org.mockito.Mockito

class CatalogueRepositoryTest{
    @get:Rule
    var instantTaskExecutorRule= InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val local = Mockito.mock(LocalDataSource::class.java)
    private val appExecutors = Mockito.mock(AppExecutors::class.java)

    private val catalogueRepository=FakeCatalogueRepository(remote,local,appExecutors)

    private val listMoviesResponse = DataDummy.getAllMoviesResponse()
    private val movieId =listMoviesResponse[0].id
    private val listTvShowResponse = DataDummy.getAllTvShowsResponse()
    private val tvShowId = listTvShowResponse[0].id
    private val movieResponse = DataDummy.getMovieResponse()
    private val tvShowResponse = DataDummy.getTvShowResponse()
}