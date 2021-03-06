package com.etwicaksono.infomovie2.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.*

@Entity(
    tableName = "detail_entities",
    foreignKeys = [ForeignKey(
        entity = ListEntity::class,
        parentColumns = ["id"],
        childColumns = ["id"]
    )],
    indices = [Index(value = ["id"])]
)
data class DetailEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String?,
    @ColumnInfo(name = "genres")
    val genres: String?,
    @ColumnInfo(name = "overview")
    val overview: String?,
    @ColumnInfo(name = "poster_path")
    val posterPath: String?,
    @ColumnInfo(name = "release_date")
    val releaseDate: String?,
    @ColumnInfo(name = "year")
    val year: String?,
    @ColumnInfo(name = "runtime")
    val runtime: String?,
    @ColumnInfo(name = "title")
    val title: String?,
    @ColumnInfo(name = "vote_average")
    val voteAverage: String?,
    @ColumnInfo(name = "favorite")
    var favorite: Boolean = false,
)