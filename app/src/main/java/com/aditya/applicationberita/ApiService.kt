package com.aditya.applicationberita

import com.aditya.applicationberita.Data.News
import retrofit2.Call
import retrofit2.http.GET


interface ApiService {
    @GET("news")
    fun getNews(): Call<List<News>>
}


