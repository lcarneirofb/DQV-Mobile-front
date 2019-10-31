package com.example.dqv.services

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface DQV {

    @FormUrlEncoded
    @POST("pessoa")
    fun autenticateUser(
        @Field("email") user:String,
        @Field("pass") pass:String
    )

}