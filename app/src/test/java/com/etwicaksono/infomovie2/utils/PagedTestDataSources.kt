package com.etwicaksono.infomovie2.utils

import androidx.paging.PagedList
import androidx.paging.PositionalDataSource
import com.etwicaksono.infomovie2.data.source.local.entity.ListEntity
import java.util.concurrent.Executors

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