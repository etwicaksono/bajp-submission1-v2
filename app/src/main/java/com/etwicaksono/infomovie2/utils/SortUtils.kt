package com.etwicaksono.infomovie2.utils

import androidx.sqlite.db.SimpleSQLiteQuery

object SortUtils {
    const val RANDOM = "RANDOM"
    const val RELEASE_DATE = "RELEASE_DATE"
    const val TITLE = "TITLE"
    const val VOTE = "VOTE"

    fun getSortedQuery(filter: String): SimpleSQLiteQuery {
        val simpleQuery = StringBuilder().append("SELECT * FROM list_entities ")
        when (filter) {
            RANDOM -> simpleQuery.append("ORDER BY RANDOM()")
            RELEASE_DATE -> simpleQuery.append("ORDER BY release_date DESC")
            TITLE -> simpleQuery.append("ORDER BY title ASC")
            VOTE -> simpleQuery.append("ORDER BY vote ASC")
        }
        return SimpleSQLiteQuery(simpleQuery.toString())
    }
}