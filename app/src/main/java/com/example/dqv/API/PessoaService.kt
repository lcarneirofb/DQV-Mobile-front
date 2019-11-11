package com.example.dqv.API

import com.example.dqv.beans.Pessoa
import retrofit2.Call
import retrofit2.http.GET

interface PessoaService{
    @GET("pessoa")
    fun list() : Call<List<Pessoa>>
}