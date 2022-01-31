package com.etwicaksono.infomovie2.data.source.remote

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.etwicaksono.infomovie2.data.source.remote.api.ApiConfig
import com.etwicaksono.infomovie2.data.source.remote.response.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {

    fun getPopularMovies(): LiveData<ApiResponse<List<ResponseMovieItem>>> {
        val resultMovies = MutableLiveData<ApiResponse<List<ResponseMovieItem>>>()
        api.getPopularMovie().enqueue(object : Callback<ResponseCatalogue<ResponseMovieItem>> {
            override fun onResponse(
                call: Call<ResponseCatalogue<ResponseMovieItem>>,
                response: Response<ResponseCatalogue<ResponseMovieItem>>
            ) {
                if (response.isSuccessful) {
                    resultMovies.value = response.body()?.let { ApiResponse.success(it.result) }
                } else {
                    Log.e(ContentValues.TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ResponseCatalogue<ResponseMovieItem>>, t: Throwable) {
                Log.e(ContentValues.TAG, "onFailure: ${t.message.toString()}")
            }

        })

        return resultMovies
    }

     fun getPopularTvShow(): LiveData<ApiResponse<List<ResponseTvShowItem>>> {
        val resultTvShow = MutableLiveData<ApiResponse<List<ResponseTvShowItem>>>()
        api.getPopularTvShow().enqueue(object : Callback<ResponseCatalogue<ResponseTvShowItem>> {
            override fun onResponse(
                call: Call<ResponseCatalogue<ResponseTvShowItem>>,
                response: Response<ResponseCatalogue<ResponseTvShowItem>>
            ) {
                if (response.isSuccessful) {
                    resultTvShow.value = response.body()?.let { ApiResponse.success(it.result) }
                } else {
                    Log.e(ContentValues.TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(
                call: Call<ResponseCatalogue<ResponseTvShowItem>>,
                t: Throwable
            ) {
                Log.e(ContentValues.TAG, "onFailure: ${t.message.toString()}")
            }

        })

        return resultTvShow
    }


    fun getMovieDetail(movieId: Int): LiveData<ApiResponse<ResponseDetailMovie>> {
        val resultDetail = MutableLiveData<ApiResponse<ResponseDetailMovie>>()
        api.getDetailMovie(movieId).enqueue(object : Callback<ResponseDetailMovie> {
            override fun onResponse(
                call: Call<ResponseDetailMovie>,
                response: Response<ResponseDetailMovie>
            ) {
                if (response.isSuccessful) {
                    resultDetail.value = response.body()?.let { ApiResponse.success(it) }
                } else {
                    Log.e(ContentValues.TAG, "onFailure:${response.message()}")
                }
            }

            override fun onFailure(call: Call<ResponseDetailMovie>, t: Throwable) {
                Log.e(ContentValues.TAG, "onFailure: ${t.message.toString()}")
            }

        })

        return resultDetail
    }


    fun getTvDetail(tvId: Int):LiveData<ApiResponse<ResponseDetailTv>>{
        val resultDetail = MutableLiveData<ApiResponse<ResponseDetailTv>>()
        api.getDetailTv(tvId).enqueue(object : Callback<ResponseDetailTv> {
            override fun onResponse(
                call: Call<ResponseDetailTv>,
                response: Response<ResponseDetailTv>
            ) {
                if (response.isSuccessful) {
                    resultDetail.value = response.body()?.let { ApiResponse.success(it) }
                } else {
                    Log.e(ContentValues.TAG, "onFailure:${response.message()}")
                }
            }

            override fun onFailure(call: Call<ResponseDetailTv>, t: Throwable) {
                Log.e(ContentValues.TAG, "onFailure: ${t.message.toString()}")
            }

        })

        return resultDetail
    }



    companion object {
        private val api = ApiConfig.getApiService()

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) { instance ?: RemoteDataSource() }

    }

}

