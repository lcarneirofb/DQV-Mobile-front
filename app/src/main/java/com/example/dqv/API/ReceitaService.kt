package com.example.dqv.API

import com.example.dqv.beans.Receita
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ReceitaService{
    @GET("receita/pessoa/{id}")
    fun getReceitasPaciente(@Path("id") id: Int):Call<List<Receita>>

    @GET("receita/consulta/{id}")
    fun getReceitasConsulta(@Path("id") id: Int):Call<List<Receita>>

    @GET("receita/{id}")
    fun getReceita(@Path("id") id: Int):Call<Receita>
}