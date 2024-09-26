package com.example.job1project

import retrofit2.http.GET

interface ApiService {


    @GET("products")
    suspend fun getProducts(): List<Product>

    }


