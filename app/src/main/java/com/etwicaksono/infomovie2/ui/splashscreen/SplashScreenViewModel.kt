package com.etwicaksono.infomovie2.ui.splashscreen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.etwicaksono.infomovie2.data.source.remote.api.ApiConfig
import com.etwicaksono.infomovie2.data.source.remote.response.ResponseRequestToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SplashScreenViewModel : ViewModel() {
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading
    private val _requestToken = MutableLiveData<ResponseRequestToken>()
    val requestToken: LiveData<ResponseRequestToken> = _requestToken

    init {
        getRequestToken()
    }

    private fun getRequestToken() {
        _isLoading.value = true
        val client = api.getRequestToken()
        client.enqueue(object : Callback<ResponseRequestToken> {
            override fun onResponse(
                call: Call<ResponseRequestToken>,
                response: Response<ResponseRequestToken>
            ) {
                if (!response.isSuccessful) {
                    Log.e(TAG, "getRequestToken onResponse failure: ${response.message()}")
                    Log.e(TAG, "getRequestToken onResponse failure: ${response.errorBody()}")
                } else {
                    _requestToken.postValue(response.body())
                }
                _isLoading.value = false
            }

            override fun onFailure(call: Call<ResponseRequestToken>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "getRequestToken onFailure: ${t.message.toString()}")
            }

        })
    }

    companion object {
        private val TAG = SplashScreenViewModel::class.java.simpleName
        private val api = ApiConfig.getApiService()
    }
}