package com.example.dqv.API

import com.example.dqv.beans.Horario
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface HorarioService{
    @GET("horario/diariaespecialista/{id}")
    fun getHorarioDiaria(@Path("id") idDiaria: Int):Call<List<Horario>>
}