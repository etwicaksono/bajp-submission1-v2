package com.etwicaksono.infomovie2.ui.splashscreen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.etwicaksono.infomovie2.data.source.remote.api.ApiConfig
import com.etwicaksono.infomovie2.data.source.remote.response.ResponseRequestToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SplashScreenViewModel {
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading:LiveData<Boolean> = _isLoading

    init {
        getRequestToken()
    }

    private fun getRequestToken() {
        _isLoading.value=true
        val client = api.getRequestToken()
        client.enqueue(object: Callback<ResponseRequestToken>{
            override fun onResponse(
                call: Call<ResponseRequestToken>,
                response: Response<ResponseRequestToken>
            ) {
                _isLoading.value=false
                if(!response.isSuccessful){
                    Log.e(TAG,"getRequestToken onResponse failure: ${response.message()}")
                    Log.e(TAG,"getRequestToken onResponse failure: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<ResponseRequestToken>, t: Throwable) {
                _isLoading.value=false
                Log.e(TAG,"getRequestToken onFailure: ${t.message.toString()}")
            }

        })
    }

    companion object{
        private val TAG = SplashScreenViewModel::class.java.simpleName
        private val api=ApiConfig.getApiService()
    }
}