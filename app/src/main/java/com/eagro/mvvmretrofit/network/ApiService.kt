package com.eagro.mvvmretrofit.network

import com.eagro.mvvmretrofit.model.ProductFamily
import retrofit2.Response
import retrofit2.http.GET

interface ApiService
{
    @GET("/")
    suspend fun getProducts(): Response<List<ProductFamily>>
}