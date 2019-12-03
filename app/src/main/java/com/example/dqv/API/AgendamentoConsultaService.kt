package com.example.dqv.API
import com.example.dqv.beans.AgendamentoConsulta
import com.example.dqv.beans.Pessoa
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AgendamentoConsultaService {
    @GET("agendamento")
    fun list() : Call<List<AgendamentoConsulta>>

    @GET("agendamento/{id}")
    fun get(@Path("id") id: Int):Call<AgendamentoConsulta>

    @GET("agendamento/pessoa/{id}")
    fun getAgendamentosPessoa(@Path("id") id: Int):Call<List<AgendamentoConsulta>>

    @POST("agendamento/{id}")
    fun agendarConsulta(@Body pessoa: Pessoa, @Path("id") id: Int):Call<AgendamentoConsulta>

}