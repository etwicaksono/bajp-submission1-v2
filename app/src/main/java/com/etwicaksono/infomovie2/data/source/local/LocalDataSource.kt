package com.etwicaksono.infomovie2.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.etwicaksono.infomovie2.data.source.local.entity.DetailEntity
import com.etwicaksono.infomovie2.data.source.local.entity.ListEntity
import com.etwicaksono.infomovie2.data.source.local.entity.ListWithDetail
import com.etwicaksono.infomovie2.data.source.local.room.CatalogueDao

class LocalDataSource private constructor(private val mDao: CatalogueDao) {

    fun getMovies(): DataSource.Factory<Int, ListEntity> = mDao.getMovies()

    fun getTvShow(): DataSource.Factory<Int, ListEntity> = mDao.getTvShow()

    fun getFavoriteMovies(): DataSource.Factory<Int, ListEntity> = mDao.getFavoriteMovies()

    fun getFavoriteTvShows(): DataSource.Factory<Int, ListEntity> = mDao.getFavoriteTvShows()

    fun insertCatalogues(catalogues: List<ListEntity>) = mDao.insertCatalogues(catalogues)

    fun getDetailCatalogue(id: Int): LiveData<ListWithDetail> = mDao.getDetailCatalogue(id)

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