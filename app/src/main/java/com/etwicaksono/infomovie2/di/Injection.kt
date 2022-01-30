package com.etwicaksono.infomovie2.di

import android.content.Context
import com.etwicaksono.infomovie2.data.CatalogueRepository
import com.etwicaksono.infomovie2.data.source.local.LocalDataSource
import com.etwicaksono.infomovie2.data.source.local.room.CatalogueDatabase
import com.etwicaksono.infomovie2.data.source.remote.RemoteDataSource
import com.etwicaksono.infomovie2.utils.AppExecutors

object Injection {

    fun provideRepository(context: Context): CatalogueRepository {
        val database = CatalogueDatabase.getInstance(context)
        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.catalogueDao())
        val appExecutors = AppExecutors()
        return CatalogueRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}