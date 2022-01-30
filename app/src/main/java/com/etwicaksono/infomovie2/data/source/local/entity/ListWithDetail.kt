package com.etwicaksono.infomovie2.data.source.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class ListWithDetail(
    @Embedded
    var mList: ListEntity,

    @Relation(parentColumn = "id", entityColumn = "id")
    var mDetail: DetailEntity

)
