package com.example.dqv.API

import com.example.dqv.beans.Especialista
import com.example.dqv.beans.Medico
import com.example.dqv.beans.PostTipoEspecialista
import com.example.dqv.beans.PostTipoMedico
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface EspecialistaService{
    @POST("especialista/especialidade")
    fun getEspecialistas(@Body postTipoEspecialista: PostTipoEspecialista): Call<List<Especialista>>

    @POST("medico/especialidade")
    fun getMedicos(@Body postTipoMedico: PostTipoMedico): Call<List<Medico>>



}