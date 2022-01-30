package com.etwicaksono.infomovie2.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.etwicaksono.infomovie2.data.source.local.entity.DetailEntity
import com.etwicaksono.infomovie2.data.source.local.entity.ListEntity
import com.etwicaksono.infomovie2.data.source.local.entity.ListWithDetail

@Dao
interface CatalogueDao {
    @Query("SELECT * FROM list_entities WHERE type = 'movie'")
    fun getMovies(): DataSource.Factory<Int, ListEntity>

    @Query("SELECT * FROM list_entities WHERE type = 'tv'")
    fun getTvShow(): DataSource.Factory<Int, ListEntity>

    @Query("SELECT * FROM list_entities WHERE type = 'movie' AND favorite = 1")
    fun getFavoriteMovies(): DataSource.Factory<Int, ListEntity>

    @Query("SELECT * FROM list_entities WHERE type = 'tv' AND favorite = 1")
    fun getFavoriteTvShows(): DataSource.Factory<Int, ListEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCatalogues(catalogues: List<ListEntity>)

    @Update
    fun updateCatalogues(catalogue: ListEntity)

    @Query("SELECT * FROM list_entities WHERE id=:id")
    fun getDetailCatalogue(id: Int): LiveData<ListWithDetail>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetailCatalogue(catalogue: DetailEntity)
}