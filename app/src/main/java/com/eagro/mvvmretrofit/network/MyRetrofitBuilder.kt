package com.eagro.mvvmretrofit.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MyRetrofitBuilder {

    const val BASE_URL : String = "http://mobcategories.s3-website-eu-west-1.amazonaws.com"

    val retrofitBuilder : Retrofit.Builder by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    val apiService : ApiService by lazy{
        retrofitBuilder
            .build()
            .create(ApiService::class.java)
    }
}