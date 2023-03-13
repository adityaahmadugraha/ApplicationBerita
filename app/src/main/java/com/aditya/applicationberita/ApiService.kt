package com.aditya.applicationberita

import com.aditya.applicationberita.Data.Articles
import com.aditya.applicationberita.Data.ServerRespons
import retrofit2.Call
import retrofit2.http.GET


interface ApiService {
    @GET("articles")
    fun getarticles(): Call<ServerRespons>
}


