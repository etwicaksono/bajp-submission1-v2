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
    var type: String? = null,
    @ColumnInfo(name = "release_date")
    var releaseDate: String? = null,
    @ColumnInfo(name = "year")
    var year: String? = null,
    @ColumnInfo(name = "title")
    var title: String? = null,
    @ColumnInfo(name = "plot")
    var plot: String? = null,
    @ColumnInfo(name = "poster_path")
    var posterPath: String? = null,
    @ColumnInfo(name = "vote")
    var vote: Double? = null,
) : Parcelable