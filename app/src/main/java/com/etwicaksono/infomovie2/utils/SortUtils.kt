package com.etwicaksono.infomovie2.utils

import androidx.sqlite.db.SimpleSQLiteQuery

object SortUtils {
    const val RANDOM = "RANDOM"
    const val RELEASE_DATE = "RELEASE_DATE"
    const val TITLE = "TITLE"
    const val VOTE = "VOTE"

    fun getSortedQuery(type: String, filter: String): SimpleSQLiteQuery {
        val simpleQuery = StringBuilder().append("SELECT * FROM list_entities ")
        when (filter) {
            RANDOM -> simpleQuery.append("WHERE type = '$type' ORDER BY RANDOM()")
            RELEASE_DATE -> simpleQuery.append("WHERE type = '$type' ORDER BY release_date DESC")
            TITLE -> simpleQuery.append("WHERE type = '$type' ORDER BY title ASC")
            VOTE -> simpleQuery.append("WHERE type = '$type' ORDER BY vote DESC")
        }
        return SimpleSQLiteQuery(simpleQuery.toString())
    }
}