package com.etwicaksono.infomovie2.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.DataSource
import com.etwicaksono.infomovie2.data.source.local.LocalDataSource
import com.etwicaksono.infomovie2.data.source.local.entity.ListEntity
import com.etwicaksono.infomovie2.data.source.remote.RemoteDataSource
import com.etwicaksono.infomovie2.utils.AppExecutors
import com.etwicaksono.infomovie2.utils.DataDummy
import com.etwicaksono.infomovie2.utils.PagedListUtil
import com.etwicaksono.infomovie2.utils.SortUtils
import com.etwicaksono.infomovie2.valueobject.Resource
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class CatalogueRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val catalogueRepository = FakeCatalogueRepository(remote, local, appExecutors)

    private val listMoviesResponse = DataDummy.getAllMoviesResponse()
    private val movieId = listMoviesResponse[0].id
    private val listTvShowResponse = DataDummy.getAllTvShowsResponse()
    private val tvShowId = listTvShowResponse[0].id
    private val movieResponse = DataDummy.getMovieResponse()
    private val tvShowResponse = DataDummy.getTvShowResponse()

    @Test
    fun getPopularMovies() {
        val sort = SortUtils.TITLE

        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, ListEntity>
        `when`(local.getMovies(sort)).thenReturn(dataSourceFactory)
        catalogueRepository.getPopularMovies(sort)

        val catalogues =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.getAllMoviesDummy()))
        verify(local).getMovies(sort)

        assertNotNull(catalogues.data)
        assertEquals(listMoviesResponse.size.toLong(),catalogues.data?.size?.toLong())
    }

    @Test
    fun getMovieDetail() {

    }

    @Test
    fun getPopularTvShow() {
    }

    @Test
    fun getTvShowDetail() {
    }

    @Test
    fun getFavoriteMovies() {
    }

    @Test
    fun getFavoriteTvShows() {
    }

    @Test
    fun setFavorite() {
    }
}