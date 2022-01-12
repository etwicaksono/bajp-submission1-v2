package com.etwicaksono.infomovie2.data.source.remote.api

import com.etwicaksono.infomovie2.data.source.remote.response.ResponseRequestToken
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("authentication/token/new")
    fun getRequestToken():Call<ResponseRequestToken>
}