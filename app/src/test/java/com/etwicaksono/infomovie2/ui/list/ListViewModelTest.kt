package com.etwicaksono.infomovie2.ui.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.etwicaksono.infomovie2.data.source.local.entity.ListEntity
import com.etwicaksono.infomovie2.data.source.CatalogueRepository
import com.etwicaksono.infomovie2.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ListViewModelTest {
    private lateinit var viewModel: ListViewModel

    private val dummyMovies = DataDummy.getAllMoviesDummy()
    private val dummyTvShows = DataDummy.getAllTvShowsDummy()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var observer: Observer<List<ListEntity>>


    @Before
    fun setup() {
        viewModel = ListViewModel(catalogueRepository)
    }

    @Test
    fun getAllMovies() {
        val movies = MutableLiveData<List<ListEntity>>()
        movies.value = dummyMovies

        `when`(catalogueRepository.getPopularMovies()).thenReturn(movies)

        val dataListMovies = viewModel.getAllMovies().value

        verify(catalogueRepository).getPopularMovies()
        assertNotNull(dataListMovies)
        assertEquals(20, dataListMovies?.size)

        viewModel.getAllMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }

    @Test
    fun getAllTvShows() {
        val tvShows = MutableLiveData<List<ListEntity>>()
        tvShows.value = dummyTvShows

        `when`(catalogueRepository.getPopularTvShow()).thenReturn(tvShows)

        val dataListMovies = viewModel.getAllTvShows().value

        verify(catalogueRepository).getPopularTvShow()
        assertNotNull(dataListMovies)
        assertEquals(20, dataListMovies?.size)

        viewModel.getAllTvShows().observeForever(observer)
        verify(observer).onChanged(dummyTvShows)
    }
}