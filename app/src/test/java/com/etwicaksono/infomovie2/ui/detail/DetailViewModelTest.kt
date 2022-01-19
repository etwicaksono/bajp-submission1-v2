package com.etwicaksono.infomovie2.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.etwicaksono.infomovie2.data.CatalogueModel
import com.etwicaksono.infomovie2.data.DetailItemModel
import com.etwicaksono.infomovie2.data.source.CatalogueRepository
import com.etwicaksono.infomovie2.utils.DataDummy
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
    private lateinit var observer:Observer<CatalogueModel>

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
    }


    @Test
    fun getTvShowTest() {
        val tvShowDummy = MutableLiveData<DetailItemModel>()
        tvShowDummy.value=dummyTvShow

        `when`(tvShowId?.let { catalogueRepository.getTvShowDetail(it) }).thenReturn(tvShowDummy)
        val movieData = tvShowId?.let { viewModel.getTvDetail(it).value } as DetailItemModel

        Assert.assertNotNull(movieData)
        Assert.assertEquals(dummyTvShow.backdropPath, movieData.backdropPath)
        Assert.assertEquals(dummyTvShow.genres, movieData.genres)
        Assert.assertEquals(dummyTvShow.id, movieData.id)
        Assert.assertEquals(dummyTvShow.overview, movieData.overview)
        Assert.assertEquals(dummyTvShow.posterPath, movieData.posterPath)
        Assert.assertEquals(dummyTvShow.releaseDate, movieData.releaseDate)
        Assert.assertEquals(dummyTvShow.year, movieData.year)
        Assert.assertEquals(dummyTvShow.runtime, movieData.runtime)
        Assert.assertEquals(dummyTvShow.title, movieData.title)
        Assert.assertEquals(dummyTvShow.voteAverage, movieData.voteAverage)
    }
}