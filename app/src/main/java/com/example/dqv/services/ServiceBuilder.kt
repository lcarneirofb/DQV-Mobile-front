package com.example.dqv.services

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    //Switch to the actual backend URL
    private const val URL = "http://34.67.51.16:5080/dqv"
    private val okHttpClient = OkHttpClient.Builder()
    private val builder = Retrofit.Builder().baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient.build())
    private val retrofit = builder.build()

    fun <T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }


}