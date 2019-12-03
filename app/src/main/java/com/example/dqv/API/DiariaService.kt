package com.example.dqv.API

import com.example.dqv.beans.Diaria
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DiariaService{
    @GET("diaria/especialista/{id}")
    fun getDiarias(@Path("id") idEspecialista: Int): Call<List<Diaria>>
}