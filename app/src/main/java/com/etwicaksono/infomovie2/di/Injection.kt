package com.etwicaksono.infomovie2.di

import com.etwicaksono.infomovie2.data.CatalogueRepository
import com.etwicaksono.infomovie2.data.source.remote.RemoteDataSource

object Injection {

    fun provideCatalogueRepository(): CatalogueRepository {
        val remoteDataSource=RemoteDataSource.getInstance()
        return CatalogueRepository.getInstance(remoteDataSource)
    }
}