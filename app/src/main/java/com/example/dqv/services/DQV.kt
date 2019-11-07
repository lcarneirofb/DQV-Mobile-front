package com.example.dqv.services

import com.example.dqv.services.models.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface DQV {

    @FormUrlEncoded
    @POST("pessoa/login")
    fun authenticateUser(
        @Field("email") user:String,
        @Field("pass") pass:String
    ):Call<LoginResponse>





}