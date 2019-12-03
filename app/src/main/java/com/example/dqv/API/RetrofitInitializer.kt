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

    fun agendamentoConsultaService() : AgendamentoConsultaService{
        return retrofit.create(AgendamentoConsultaService::class.java)
    }

    fun receitaService() : ReceitaService{
        return retrofit.create(ReceitaService::class.java)
    }

    fun especialistaService() : EspecialistaService{
        return retrofit.create(EspecialistaService::class.java)
    }


}