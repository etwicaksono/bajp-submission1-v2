package com.etwicaksono.infomovie2.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.etwicaksono.infomovie2.data.source.local.entity.DetailEntity
import com.etwicaksono.infomovie2.data.source.local.entity.ListEntity
import com.etwicaksono.infomovie2.data.source.local.room.CatalogueDao

class LocalDataSource private constructor(private val mDao: CatalogueDao) {

    fun getMovies(): DataSource.Factory<Int, ListEntity> = mDao.getMovies()

    fun getTvShow(): DataSource.Factory<Int, ListEntity> = mDao.getTvShow()

    fun getFavorite(): DataSource.Factory<Int, ListEntity> = mDao.getFavorite()

    fun insertCatalogues(catalogues: List<ListEntity>) = mDao.insertCatalogues(catalogues)

    fun updateCatalogues(catalogue: ListEntity) = mDao.updateCatalogues(catalogue)

    fun getDetailCatalogue(id: Int): LiveData<DetailEntity> = mDao.getDetailCatalogue(id)

    fun insertDetailCatalogue(catalogue: DetailEntity) = mDao.insertDetailCatalogue(catalogue)

    fun setFavorite(film: ListEntity, newState: Boolean) {
        film.favorite = newState
        mDao.updateCatalogues(film)
    }

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(mDao: CatalogueDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(mDao).apply { INSTANCE = this }
    }

}