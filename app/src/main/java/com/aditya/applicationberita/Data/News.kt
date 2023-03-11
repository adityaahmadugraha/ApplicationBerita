package com.aditya.applicationberita.Data

data class News(
    val status: String,
    val totalResults: Int,
    val articles: Array<Articles>
)
