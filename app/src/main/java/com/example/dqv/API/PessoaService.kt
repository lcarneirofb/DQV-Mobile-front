package com.example.dqv.API

import com.example.dqv.beans.Pessoa
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PessoaService{
    @GET("pessoa")
    fun list() : Call<List<Pessoa>>

    @GET("pessoa/{id}")
    fun getPessoa(@Path("id") id: Int):Call<Pessoa>

    @POST("pessoa")
    fun updatePessoa(@Body pessoa: Pessoa):Call<Pessoa>


}