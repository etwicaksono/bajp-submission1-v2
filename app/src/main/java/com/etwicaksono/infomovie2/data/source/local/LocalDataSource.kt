package com.etwicaksono.infomovie2.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.etwicaksono.infomovie2.data.source.local.entity.DetailEntity
import com.etwicaksono.infomovie2.data.source.local.entity.ListEntity
import com.etwicaksono.infomovie2.data.source.local.room.CatalogueDao
import com.etwicaksono.infomovie2.utils.Helper
import com.etwicaksono.infomovie2.utils.SortUtils

class LocalDataSource private constructor(private val mDao: CatalogueDao) {

    fun getMovies(sort: String): DataSource.Factory<Int, ListEntity> {
        val query = SortUtils.getSortedQuery(Helper.TYPE_MOVIE, sort)
        return mDao.getMovies(query)
    }

    fun getTvShow(sort: String): DataSource.Factory<Int, ListEntity> {
        val query = SortUtils.getSortedQuery(Helper.TYPE_TV, sort)
        return mDao.getTvShow(query)
    }

    fun getFavoriteMovies(): DataSource.Factory<Int, ListEntity> = mDao.getFavoriteMovies()

    fun getFavoriteTvShows(): DataSource.Factory<Int, ListEntity> = mDao.getFavoriteTvShows()

    fun insertCatalogues(catalogues: List<ListEntity>) = mDao.insertCatalogues(catalogues)

    fun getDetailCatalogue(id: Int): LiveData<DetailEntity> = mDao.getDetailCatalogue(id)

    fun insertDetailCatalogue(catalogue: DetailEntity) = mDao.insertDetailCatalogue(catalogue)

    fun setFavorite(film: DetailEntity, newState: Boolean) {
        film.favorite = newState
        mDao.updateCatalogues(film)
    }

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(mDao: CatalogueDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(mDao).apply { INSTANCE = this }
    }

}