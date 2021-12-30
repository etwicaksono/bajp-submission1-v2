package com.etwicaksono.infomovie2.utils

import android.content.Context
import java.io.IOException
import kotlin.math.floor

fun getJsonDataFromAsset(context: Context, fileName: String): String? {
    val jsonString: String
    try {
        jsonString = context.assets.open(fileName).bufferedReader().use {
            it.readText()
        }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return null
    }
    return jsonString
}

fun getRuntime(input: Int): String {
    val hour = floor((input.toDouble() / 60)).toInt()
    val minutes = (input % 60).toString()
    return if (hour > 0) {
        "${hour}h ${minutes}m"
    } else "${minutes}m"
}