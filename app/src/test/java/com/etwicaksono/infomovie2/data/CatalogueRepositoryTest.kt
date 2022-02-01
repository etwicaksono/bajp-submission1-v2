package com.etwicaksono.infomovie2.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.etwicaksono.infomovie2.data.source.local.LocalDataSource
import com.etwicaksono.infomovie2.data.source.local.entity.DetailEntity
import com.etwicaksono.infomovie2.data.source.local.entity.ListEntity
import com.etwicaksono.infomovie2.data.source.remote.RemoteDataSource
import com.etwicaksono.infomovie2.utils.*
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
    private val listTvShowResponse = DataDummy.getAllTvShowsResponse()
    private val movieDummy = DataDummy.getMovieDummy()
    private val tvShowDummy = DataDummy.getTvShowDummy()

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
        assertEquals(listMoviesResponse.size.toLong(), catalogues.data?.size?.toLong())
    }

    @Test
    fun getMovieDetail() {
        val dummyMovie = MutableLiveData<DetailEntity>()
        dummyMovie.value = movieDummy
        `when`(movieDummy.id.let { local.getDetailCatalogue(it) }).thenReturn(dummyMovie)

        val movieEntity =
            LiveDataTestUtil.getValue(catalogueRepository.getMovieDetail(movieDummy.id))
        verify(local).getDetailCatalogue(movieDummy.id)

        assertNotNull(movieEntity)
        assertEquals(movieDummy.id, movieEntity.data?.id)
    }

    @Test
    fun getPopularTvShow() {
        val sort = SortUtils.TITLE

        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, ListEntity>
        `when`(local.getTvShow(sort)).thenReturn(dataSourceFactory)
        catalogueRepository.getPopularTvShow(sort)

        val catalogues =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.getAllTvShowsDummy()))
        verify(local).getTvShow(sort)

        assertNotNull(catalogues.data)
        assertEquals(listTvShowResponse.size.toLong(), catalogues.data?.size?.toLong())
    }

    @Test
    fun getTvShowDetail() {
        val dummyTvShow = MutableLiveData<DetailEntity>()
        dummyTvShow.value = tvShowDummy
        `when`(tvShowDummy.id.let { local.getDetailCatalogue(it) }).thenReturn(dummyTvShow)

        val movieEntity =
            LiveDataTestUtil.getValue(catalogueRepository.getTvShowDetail(tvShowDummy.id))
        verify(local).getDetailCatalogue(tvShowDummy.id)

        assertNotNull(movieEntity)
        assertEquals(tvShowDummy.id, movieEntity.data?.id)
    }

    @Test
    fun getFavoriteMovies() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, ListEntity>
        `when`(local.getFavoriteMovies()).thenReturn(dataSourceFactory)
        catalogueRepository.getFavoriteMovies()

        val catalogues =
            PagedListUtil.mockPagedList(DataDummy.getAllMoviesDummy())
        verify(local).getFavoriteMovies()

        assertNotNull(catalogues)
        assertEquals(listMoviesResponse.size.toLong(), catalogues.size.toLong())
    }

    @Test
    fun getFavoriteTvShows() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, ListEntity>
        `when`(local.getFavoriteTvShows()).thenReturn(dataSourceFactory)
        catalogueRepository.getFavoriteTvShows()

        val catalogues =
            PagedListUtil.mockPagedList(DataDummy.getAllTvShowsDummy())
        verify(local).getFavoriteTvShows()

        assertNotNull(catalogues)
        assertEquals(listMoviesResponse.size.toLong(), catalogues.size.toLong())
    }

    @Test
    fun setFavoriteMovie() {
        val movie = movieDummy.copy(favorite = false)
        doNothing().`when`(local).setFavorite(movie, true)
        catalogueRepository.setFavorite(movie, true)

        verify(local, times(1)).setFavorite(movie, true)
    }
    @Test
    fun unsetFavoriteMovie() {
        val movie = movieDummy.copy(favorite = true)
        doNothing().`when`(local).setFavorite(movie, false)
        catalogueRepository.setFavorite(movie, false)

        verify(local, times(1)).setFavorite(movie, false)
    }
    @Test
    fun setFavoriteTvShow() {
        val tvShow = tvShowDummy.copy(favorite = false)
        doNothing().`when`(local).setFavorite(tvShow, true)
        catalogueRepository.setFavorite(tvShow, true)

        verify(local, times(1)).setFavorite(tvShow, true)
    }
    @Test
    fun unsetFavoriteTvShow() {
        val tvShow = tvShowDummy.copy(favorite = true)
        doNothing().`when`(local).setFavorite(tvShow, false)
        catalogueRepository.setFavorite(tvShow, false)

        verify(local, times(1)).setFavorite(tvShow, false)
    }
}