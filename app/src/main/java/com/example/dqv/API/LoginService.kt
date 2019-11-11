package com.example.dqv.API

import com.example.dqv.beans.Login
import com.example.dqv.beans.Pessoa
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {

    @POST("pessoa/login")
    fun authenticateUser(
        @Body login: Login
    ): Call<Pessoa>
}