package com.aditya.applicationberita

import com.aditya.applicationberita.Data.Articles
import com.aditya.applicationberita.Data.ServerRespons
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    @GET("top-headlines")
    fun getarticles(
        @Query("country")country: String,
        @Query("apiKey")apiKey: String =BuildConfig.API_KEY
    ): Call<ServerRespons>
}


