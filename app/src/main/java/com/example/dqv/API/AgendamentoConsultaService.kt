package com.example.dqv.API
import com.example.dqv.beans.AgendamentoConsulta
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AgendamentoConsultaService {
    @GET("agendamento")
    fun list() : Call<List<AgendamentoConsulta>>

    @GET("agendamento/{id}")
    fun get(@Path("id") id: Int):Call<AgendamentoConsulta>

    @GET("agendamento/pessoa/{id}")
    fun getAgendamentosPessoa(@Path("id") id: Int):Call<List<AgendamentoConsulta>>

}