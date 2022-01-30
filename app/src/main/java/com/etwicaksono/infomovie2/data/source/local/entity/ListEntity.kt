package com.etwicaksono.infomovie2.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "list_entities")
data class ListEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "type")
    val type: String? = null,
    @ColumnInfo(name = "release_date")
    val releaseDate: String? = null,
    @ColumnInfo(name = "year")
    val year: String? = null,
    @ColumnInfo(name = "title")
    val title: String? = null,
    @ColumnInfo(name = "plot")
    val plot: String? = null,
    @ColumnInfo(name = "poster_path")
    val posterPath: String? = null,
    @ColumnInfo(name = "favorite")
    val favorite: Boolean = false,
) : Parcelable