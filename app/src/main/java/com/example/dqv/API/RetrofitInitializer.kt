package com.example.dqv.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {
   private val retrofit = Retrofit.Builder()
            .baseUrl("http://34.67.51.16:5080/dqv/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun pessoaService () : PessoaService{
        return retrofit.create(PessoaService::class.java)
    }

    fun loginService () : LoginService{
        return retrofit.create(LoginService::class.java)
    }
}