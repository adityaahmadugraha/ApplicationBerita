package com.aditya.applicationberita.Fragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aditya.applicationberita.ApiConfig
import com.aditya.applicationberita.Data.Articles
import com.aditya.applicationberita.Data.ServerRespons
import retrofit2.Call
import retrofit2.Response

class HomeViewModel : ViewModel() {

    private val _articles = MutableLiveData<ServerRespons>()
    val articles: LiveData<ServerRespons> = _articles

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        getarticles()
    }

    fun getarticles() {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getarticles()
        client.enqueue(object : retrofit2.Callback<ServerRespons> {
            override fun onResponse(call: Call<ServerRespons>, response: Response<ServerRespons>) {
                if (response.isSuccessful) {
                    _isLoading.value = false
                    val responseBody = response.body()
                    if (responseBody != null) {
                        _articles.value = responseBody
                    }
                }
            }

            override fun onFailure(call: Call<ServerRespons>, t: Throwable) {
                _isLoading.value = false
                Log.d("Respons::::::::", t.message.toString())
            }
        })
    }
}