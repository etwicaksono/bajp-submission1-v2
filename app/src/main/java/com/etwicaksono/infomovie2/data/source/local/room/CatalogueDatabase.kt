package com.etwicaksono.infomovie2.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.etwicaksono.infomovie2.data.source.local.entity.DetailEntity
import com.etwicaksono.infomovie2.data.source.local.entity.ListEntity

@Database(
    entities = [ListEntity::class, DetailEntity::class],
    version = 1,
    exportSchema = false
)
abstract class CatalogueDatabase : RoomDatabase() {

    abstract fun catalogueDao(): CatalogueDao

    companion object {
        @Volatile
        private var INSTANCE: CatalogueDatabase? = null

        fun getInstance(context: Context): CatalogueDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    CatalogueDatabase::class.java,
                    "Catalogue.db"
                ).build().apply {
                    INSTANCE = this
                }
            }
    }

}