package com.example.dqv.services

import retrofit2.Call
import retrofit2.http.GET

interface DQV {
    @GET("agendamento")
    fun autenticateUser(): Call<List<String>>
}