package com.etwicaksono.infomovie2.ui.homelist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.paging.PositionalDataSource
import com.etwicaksono.infomovie2.data.CatalogueRepository
import com.etwicaksono.infomovie2.data.source.local.entity.ListEntity
import com.etwicaksono.infomovie2.utils.DataDummy
import com.etwicaksono.infomovie2.utils.SortUtils
import com.etwicaksono.infomovie2.valueobject.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import java.util.concurrent.Executors

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
    private lateinit var observer: Observer<Resource<PagedList<ListEntity>>>


    @Before
    fun setup() {
        viewModel = ListViewModel(catalogueRepository)
    }

    @Test
    fun `getAllMovies should be success`() {
        val sort = SortUtils.TITLE
        val movies = PagedTestDataSources.snapshot(dummyMovies)
        val expected = MutableLiveData<Resource<PagedList<ListEntity>>>()
        expected.value = Resource.success(movies)
        `when`(catalogueRepository.getPopularMovies(sort)).thenReturn(expected)

        viewModel.sort.value = sort
        viewModel.getAllMovies().observeForever(observer)
        verify(observer).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.getAllMovies().value

        assertNotNull(actualValue)
        assertEquals(expectedValue, actualValue)
        assertEquals(expectedValue?.data, actualValue?.data)
        assertEquals(expectedValue?.data?.size, actualValue?.data?.size)
    }

    @Test
    fun `getAllMovies should be success but data is empty`() {
        val sort = SortUtils.TITLE
        val movies = PagedTestDataSources.snapshot()
        val expected = MutableLiveData<Resource<PagedList<ListEntity>>>()
        expected.value = Resource.success(movies)
        `when`(catalogueRepository.getPopularMovies(sort)).thenReturn(expected)

        viewModel.getAllMovies().observeForever(observer)
        verify(observer).onChanged(expected.value)

        val actualValueDataSize = viewModel.getAllMovies().value?.data?.size
        assertTrue(
            "size of data should be 0, actual is $actualValueDataSize",
            actualValueDataSize == 0
        )
    }

    @Test
    fun `getAllMovies should be error`() {
        val sort = SortUtils.TITLE
        val expectedMessage = "Error happened"
        val expected = MutableLiveData<Resource<PagedList<ListEntity>>>()
        expected.value = Resource.error(expectedMessage, null)
        `when`(catalogueRepository.getPopularMovies(sort)).thenReturn(expected)

        viewModel.getAllMovies().observeForever(observer)
        verify(observer).onChanged(expected.value)

        val actualMessage = viewModel.getAllMovies().value?.message
        assertEquals(expectedMessage,actualMessage)
    }
    @Test
    fun `getAllTvShows should be success`() {
        val sort = SortUtils.TITLE
        val tvShow = PagedTestDataSources.snapshot(dummyTvShows)
        val expected = MutableLiveData<Resource<PagedList<ListEntity>>>()
        expected.value = Resource.success(tvShow)
        `when`(catalogueRepository.getPopularTvShow(sort)).thenReturn(expected)

        viewModel.sort.value = sort
        viewModel.getAllTvShows().observeForever(observer)
        verify(observer).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.getAllTvShows().value

        assertNotNull(actualValue)
        assertEquals(expectedValue, actualValue)
        assertEquals(expectedValue?.data, actualValue?.data)
        assertEquals(expectedValue?.data?.size, actualValue?.data?.size)
    }

    @Test
    fun `getAllTvShows should be success but data is empty`() {
        val sort = SortUtils.TITLE
        val tvShow = PagedTestDataSources.snapshot()
        val expected = MutableLiveData<Resource<PagedList<ListEntity>>>()
        expected.value = Resource.success(tvShow)
        `when`(catalogueRepository.getPopularTvShow(sort)).thenReturn(expected)

        viewModel.getAllTvShows().observeForever(observer)
        verify(observer).onChanged(expected.value)

        val actualValueDataSize = viewModel.getAllTvShows().value?.data?.size
        assertTrue(
            "size of data should be 0, actual is $actualValueDataSize",
            actualValueDataSize == 0
        )
    }

    @Test
    fun `getAllTvShows should be error`() {
        val sort = SortUtils.TITLE
        val expectedMessage = "Error happened"
        val expected = MutableLiveData<Resource<PagedList<ListEntity>>>()
        expected.value = Resource.error(expectedMessage, null)
        `when`(catalogueRepository.getPopularTvShow(sort)).thenReturn(expected)

        viewModel.getAllTvShows().observeForever(observer)
        verify(observer).onChanged(expected.value)

        val actualMessage = viewModel.getAllTvShows().value?.message
        assertEquals(expectedMessage,actualMessage)
    }


    class PagedTestDataSources private constructor(private val items: List<ListEntity>) :
        PositionalDataSource<ListEntity>() {
        override fun loadInitial(
            params: LoadInitialParams,
            callback: LoadInitialCallback<ListEntity>
        ) {
            callback.onResult(items, 0, items.size)
        }

        override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<ListEntity>) {
            val start = params.startPosition
            val end = params.startPosition + params.loadSize
            callback.onResult(items.subList(start, end))
        }

        companion object {
            fun snapshot(items: List<ListEntity> = listOf()): PagedList<ListEntity> {
                return PagedList.Builder(PagedTestDataSources(items), 10)
                    .setNotifyExecutor(Executors.newSingleThreadExecutor())
                    .setFetchExecutor(Executors.newSingleThreadExecutor())
                    .build()
            }
        }
    }
}