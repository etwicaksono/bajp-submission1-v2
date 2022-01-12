package com.etwicaksono.infomovie2.data.source.remote.response


import com.google.gson.annotations.SerializedName

data class ResponseRequestToken(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("expires_at")
    val expiresAt: String,
    @SerializedName("request_token")
    val requestToken: String
)