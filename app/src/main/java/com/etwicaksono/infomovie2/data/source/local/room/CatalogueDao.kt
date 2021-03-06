package com.etwicaksono.infomovie2.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery
import com.etwicaksono.infomovie2.data.source.local.entity.DetailEntity
import com.etwicaksono.infomovie2.data.source.local.entity.ListEntity
import com.etwicaksono.infomovie2.utils.Helper

@Dao
interface CatalogueDao {
    @RawQuery(observedEntities = [ListEntity::class])
    fun getMovies(query:SupportSQLiteQuery): DataSource.Factory<Int, ListEntity>

    @RawQuery(observedEntities = [ListEntity::class])
    fun getTvShow(query:SupportSQLiteQuery): DataSource.Factory<Int, ListEntity>

    @Query("SELECT * FROM list_entities JOIN detail_entities ON list_entities.id = detail_entities.id WHERE type = '${Helper.TYPE_MOVIE}' AND detail_entities.favorite = 1")
    fun getFavoriteMovies(): DataSource.Factory<Int, ListEntity>

    @Query("SELECT * FROM list_entities JOIN detail_entities ON list_entities.id = detail_entities.id WHERE type = '${Helper.TYPE_TV}' AND detail_entities.favorite = 1")
    fun getFavoriteTvShows(): DataSource.Factory<Int, ListEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCatalogues(catalogues: List<ListEntity>)

    @Update
    fun updateCatalogues(catalogue: DetailEntity)

    @Query("SELECT * FROM detail_entities WHERE id=:id")
    fun getDetailCatalogue(id: Int): LiveData<DetailEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetailCatalogue(catalogue: DetailEntity)
}