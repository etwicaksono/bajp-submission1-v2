package com.etwicaksono.infomovie2.ui.favoritelist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.etwicaksono.infomovie2.data.CatalogueRepository
import com.etwicaksono.infomovie2.data.source.local.entity.ListEntity
import com.etwicaksono.infomovie2.utils.DataDummy
import com.etwicaksono.infomovie2.utils.PagedTestDataSources
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteListViewModelTest {
    private lateinit var viewModel: FavoriteListViewModel

    private val dummyMovies = DataDummy.getAllMoviesDummy()
    private val dummyTvShows = DataDummy.getAllTvShowsDummy()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var observer: Observer<PagedList<ListEntity>>


    @Before
    fun setup() {
        viewModel = FavoriteListViewModel(catalogueRepository)
    }

    @Test
    fun `getFavoriteMovies should be success`() {
        val expected = MutableLiveData<PagedList<ListEntity>>()
        expected.value = PagedTestDataSources.snapshot(dummyMovies)

        `when`(catalogueRepository.getFavoriteMovies()).thenReturn(expected)

        viewModel.getFavoriteMovies().observeForever(observer)
        verify(observer).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.getFavoriteMovies().value

        assertEquals(expectedValue, actualValue)
        assertEquals(expectedValue?.snapshot(), actualValue?.snapshot())
        assertEquals(expectedValue?.size, actualValue?.size)
    }

    @Test
    fun `getFavoriteMovies should be success but data is empty`() {
        val expected = MutableLiveData<PagedList<ListEntity>>()
        expected.value = PagedTestDataSources.snapshot()

        `when`(catalogueRepository.getFavoriteMovies()).thenReturn(expected)

        viewModel.getFavoriteMovies().observeForever(observer)
        verify(observer).onChanged(expected.value)

        val actualValueDataSize = viewModel.getFavoriteMovies().value?.size
        assertTrue(
            "size of data should be 0, actual is $actualValueDataSize",
            actualValueDataSize == 0
        )
    }

    @Test
    fun `getFavoriteTvShows should be success`() {
        val expected = MutableLiveData<PagedList<ListEntity>>()
        expected.value = PagedTestDataSources.snapshot(dummyTvShows)

        `when`(catalogueRepository.getFavoriteTvShows()).thenReturn(expected)

        viewModel.getFavoriteTvShows().observeForever(observer)
        verify(observer).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.getFavoriteTvShows().value

        assertEquals(expectedValue, actualValue)
        assertEquals(expectedValue?.snapshot(), actualValue?.snapshot())
        assertEquals(expectedValue?.size, actualValue?.size)
    }

    @Test
    fun `getFavoriteTvShows should be success but data is empty`() {
        val expected = MutableLiveData<PagedList<ListEntity>>()
        expected.value = PagedTestDataSources.snapshot()

        `when`(catalogueRepository.getFavoriteTvShows()).thenReturn(expected)

        viewModel.getFavoriteTvShows().observeForever(observer)
        verify(observer).onChanged(expected.value)

        val actualValueDataSize = viewModel.getFavoriteTvShows().value?.size
        assertTrue(
            "size of data should be 0, actual is $actualValueDataSize",
            actualValueDataSize == 0
        )
    }

}