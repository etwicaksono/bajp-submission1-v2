package com.etwicaksono.infomovie2.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.etwicaksono.infomovie2.LiveDataTestUtil
import com.etwicaksono.infomovie2.data.source.remote.RemoteDataSource
import com.etwicaksono.infomovie2.utils.DataDummy
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class CatalogueRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule=InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val catalogueRepository=FakeCatalogueRepository(remote)

    private val listMoviesResponse = DataDummy.getAllMoviesResponse()
    private val movieId =listMoviesResponse[0].id
    private val listTvShowResponse = DataDummy.getAllTvShowsResponse()
    private val tvShowId = listTvShowResponse[0].id
    private val movieResponse = DataDummy.getMovieResponse()
    private val tvShowResponse = DataDummy.getTvShowResponse()

    @Test
    fun getPopularMovies() {
        runBlocking {
            doAnswer { invocation->
                (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback).onPopularMoviesReceived(listMoviesResponse)
                null
            }.`when`(remote).getPopularMovies(any())
        }

        val data = LiveDataTestUtil.getValue(catalogueRepository.getPopularMovies())

        runBlocking {
            verify(remote).getPopularMovies(any())
        }

        assertNotNull(data)
        assertEquals(listMoviesResponse.size.toLong(),data.size.toLong())
    }

    @Test
    fun getMovieDetail() {
        runBlocking {
            doAnswer { invocation->
                (invocation.arguments[1] as RemoteDataSource.LoadMovieDetailCallback).onMoviedetailReceived(movieResponse)
                null
            }.`when`(remote).getMovieDetail(eq(movieId),any())
        }

        val data = LiveDataTestUtil.getValue(catalogueRepository.getMovieDetail(movieId))

        runBlocking {
            verify(remote).getMovieDetail(eq(movieId),any())
        }

        assertNotNull(data)
        assertEquals(movieResponse.id,data.id)
    }

    @Test
    fun getPopularTvShow() {
         runBlocking {
            doAnswer { invocation->
                (invocation.arguments[0] as RemoteDataSource.LoadTvShowsCallback).onPopularTvShowsReceived(listTvShowResponse)
                null
            }.`when`(remote).getPopularTvShow(any())
        }

        val data = LiveDataTestUtil.getValue(catalogueRepository.getPopularTvShow())

        runBlocking {
            verify(remote).getPopularTvShow(any())
        }

        assertNotNull(data)
        assertEquals(listTvShowResponse.size.toLong(),data.size.toLong())
    }

    @Test
    fun getTvShowDetail() {
         runBlocking {
            doAnswer { invocation->
                (invocation.arguments[1] as RemoteDataSource.LoadTvDetailCallback).onTvDetailReceived(tvShowResponse)
                null
            }.`when`(remote).getTvDetail(eq(tvShowId),any())
        }

        val data = LiveDataTestUtil.getValue(catalogueRepository.getTvShowDetail(tvShowId))

        runBlocking {
            verify(remote).getTvDetail(eq(tvShowId),any())
        }

        assertNotNull(data)
        assertEquals(tvShowResponse.id,data.id)
    }
}