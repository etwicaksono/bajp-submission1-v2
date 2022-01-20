package com.etwicaksono.infomovie2.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.etwicaksono.infomovie2.data.DetailItemModel
import com.etwicaksono.infomovie2.data.source.CatalogueRepository
import com.etwicaksono.infomovie2.utils.DataDummy
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
    private var dummyMovie = DataDummy.getMovieDummy()
    private var dummyTvShow = DataDummy.getTvShowDummy()
    private var movieId = dummyMovie.id
    private var tvShowId = dummyTvShow.id

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var observer:Observer<DetailItemModel>

    @Before
    fun setup() {
        viewModel = DetailViewModel(catalogueRepository)
    }

    @Test
    fun getMovieTest() {
        val movieDummy = MutableLiveData<DetailItemModel>()
        movieDummy.value=dummyMovie

        `when`(movieId?.let { catalogueRepository.getMovieDetail(it) }).thenReturn(movieDummy)
        val movieData = movieId?.let { viewModel.getMovieDetail(it).value } as DetailItemModel

        Assert.assertNotNull(movieData)
        Assert.assertEquals(dummyMovie.backdropPath, movieData.backdropPath)
        Assert.assertEquals(dummyMovie.genres, movieData.genres)
        Assert.assertEquals(dummyMovie.id, movieData.id)
        Assert.assertEquals(dummyMovie.overview, movieData.overview)
        Assert.assertEquals(dummyMovie.posterPath, movieData.posterPath)
        Assert.assertEquals(dummyMovie.releaseDate, movieData.releaseDate)
        Assert.assertEquals(dummyMovie.year, movieData.year)
        Assert.assertEquals(dummyMovie.runtime, movieData.runtime)
        Assert.assertEquals(dummyMovie.title, movieData.title)
        Assert.assertEquals(dummyMovie.voteAverage, movieData.voteAverage)

        movieId?.let { viewModel.getMovieDetail(it).observeForever(observer) }
        verify(observer).onChanged(dummyMovie)
    }


    @Test
    fun getTvShowTest() {
        val tvShowDummy = MutableLiveData<DetailItemModel>()
        tvShowDummy.value=dummyTvShow

        `when`(tvShowId?.let { catalogueRepository.getTvShowDetail(it) }).thenReturn(tvShowDummy)
        val tvShowData = tvShowId?.let { viewModel.getTvDetail(it).value } as DetailItemModel

        Assert.assertNotNull(tvShowData)
        Assert.assertEquals(dummyTvShow.backdropPath, tvShowData.backdropPath)
        Assert.assertEquals(dummyTvShow.genres, tvShowData.genres)
        Assert.assertEquals(dummyTvShow.id, tvShowData.id)
        Assert.assertEquals(dummyTvShow.overview, tvShowData.overview)
        Assert.assertEquals(dummyTvShow.posterPath, tvShowData.posterPath)
        Assert.assertEquals(dummyTvShow.releaseDate, tvShowData.releaseDate)
        Assert.assertEquals(dummyTvShow.year, tvShowData.year)
        Assert.assertEquals(dummyTvShow.runtime, tvShowData.runtime)
        Assert.assertEquals(dummyTvShow.title, tvShowData.title)
        Assert.assertEquals(dummyTvShow.voteAverage, tvShowData.voteAverage)

        tvShowId?.let { viewModel.getTvDetail(it).observeForever(observer) }
        verify(observer).onChanged(dummyTvShow)
    }
}