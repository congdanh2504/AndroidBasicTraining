package com.example.mvvmexample.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmexample.api.RetrofitInstance
import com.example.mvvmexample.models.Movies
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MovieViewModel : ViewModel() {
    private var movieLiveData = MutableLiveData<List<com.example.mvvmexample.models.Result>>()
    fun getPopularMovies() {
        RetrofitInstance.api.getPopularMovies("7ccfc7beaffa9ce717fe88fef33a54c7")
            .enqueue(object  : Callback<Movies>{
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                if (response.body()!=null){
                    movieLiveData.value = response.body()!!.results
                }
                else{
                    return
                }
            }
            override fun onFailure(call: Call<Movies>, t: Throwable) {
                Log.d("TAG",t.message.toString())
            }
        })
    }
    fun observeMovieLiveData() : LiveData<List<com.example.mvvmexample.models.Result>> {
        return movieLiveData
    }
}