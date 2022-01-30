package com.etwicaksono.infomovie2.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.etwicaksono.infomovie2.data.source.local.entity.DetailEntity
import com.etwicaksono.infomovie2.data.source.local.entity.ListEntity

@Dao
interface CatalogueDao {
    @Query("SELECT * FROM list_entities WHERE type = 'movies'")
    fun getMovies(): DataSource.Factory<Int, ListEntity>

    @Query("SELECT * FROM list_entities WHERE type = 'tv'")
    fun getTvShow(): DataSource.Factory<Int, ListEntity>

    @Query("SELECT * FROM list_entities WHERE favorite = 1")
    fun getFavorite(): DataSource.Factory<Int, ListEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCatalogues(catalogues: List<ListEntity>)

    @Update
    fun updateCatalogues(catalogues: List<ListEntity>)

    @Query("SELECT * FROM detail_entities WHERE id=:id")
    fun getDetailCatalogue(id: Int): LiveData<DetailEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetailCatalogue(catalogue: DetailEntity)
}