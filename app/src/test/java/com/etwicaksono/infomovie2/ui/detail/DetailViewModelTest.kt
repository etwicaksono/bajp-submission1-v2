package com.etwicaksono.infomovie2.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.etwicaksono.infomovie2.data.CatalogueRepository
import com.etwicaksono.infomovie2.data.source.local.entity.DetailEntity
import com.etwicaksono.infomovie2.utils.DataDummy
import com.etwicaksono.infomovie2.valueobject.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel
    private var dummyMovie = Resource.success(DataDummy.getMovieDummy())
    private var dummyTvShow = Resource.success(DataDummy.getTvShowDummy())
    private var movieId = dummyMovie.data?.id
    private var tvShowId = dummyTvShow.data?.id

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var observer: Observer<Resource<DetailEntity>>

    @Before
    fun setup() {
        viewModel = DetailViewModel(catalogueRepository)
    }

    @Test
    fun getMovieTest() {

        val movieDummy = MutableLiveData<Resource<DetailEntity>>()
        movieDummy.value = dummyMovie

        `when`(movieId?.let { catalogueRepository.getMovieDetail(it) }).thenReturn(movieDummy)
        val movieData = movieId?.let { viewModel.getMovieDetail(it).value }

        Assert.assertNotNull(movieData)
        Assert.assertEquals(dummyMovie.data?.backdropPath, movieData?.data?.backdropPath)
        Assert.assertEquals(dummyMovie.data?.genres, movieData?.data?.genres)
        Assert.assertEquals(dummyMovie.data?.id, movieData?.data?.id)
        Assert.assertEquals(dummyMovie.data?.overview, movieData?.data?.overview)
        Assert.assertEquals(dummyMovie.data?.posterPath, movieData?.data?.posterPath)
        Assert.assertEquals(dummyMovie.data?.releaseDate, movieData?.data?.releaseDate)
        Assert.assertEquals(dummyMovie.data?.year, movieData?.data?.year)
        Assert.assertEquals(dummyMovie.data?.runtime, movieData?.data?.runtime)
        Assert.assertEquals(dummyMovie.data?.title, movieData?.data?.title)
        Assert.assertEquals(dummyMovie.data?.voteAverage, movieData?.data?.voteAverage)

        viewModel.getMovieDetail(movieId!!).observeForever(observer)
        verify(observer).onChanged(movieDummy.value)
    }


    @Test
    fun getTvShowTest() {
        val tvShowDummy = MutableLiveData<Resource<DetailEntity>>()
        tvShowDummy.value = dummyTvShow

        `when`(tvShowId?.let { catalogueRepository.getTvShowDetail(it) }).thenReturn(tvShowDummy)
        val tvShowData = tvShowId?.let { viewModel.getTvDetail(it).value }

        Assert.assertNotNull(tvShowData)
        Assert.assertEquals(dummyTvShow.data?.backdropPath, tvShowData?.data?.backdropPath)
        Assert.assertEquals(dummyTvShow.data?.genres, tvShowData?.data?.genres)
        Assert.assertEquals(dummyTvShow.data?.id, tvShowData?.data?.id)
        Assert.assertEquals(dummyTvShow.data?.overview, tvShowData?.data?.overview)
        Assert.assertEquals(dummyTvShow.data?.posterPath, tvShowData?.data?.posterPath)
        Assert.assertEquals(dummyTvShow.data?.releaseDate, tvShowData?.data?.releaseDate)
        Assert.assertEquals(dummyTvShow.data?.year, tvShowData?.data?.year)
        Assert.assertEquals(dummyTvShow.data?.runtime, tvShowData?.data?.runtime)
        Assert.assertEquals(dummyTvShow.data?.title, tvShowData?.data?.title)
        Assert.assertEquals(dummyTvShow.data?.voteAverage, tvShowData?.data?.voteAverage)

        viewModel.getTvDetail(tvShowId!!).observeForever(observer)
        verify(observer).onChanged(tvShowDummy.value)
    }
}