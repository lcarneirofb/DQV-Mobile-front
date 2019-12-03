package com.example.dqv.API

import com.example.dqv.beans.Especialista
import com.example.dqv.beans.PostTipoMedico
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface EspecialistaService{
    @POST("especialista/especialidade")
    fun getEspecialistas(@Body postTipoMedico: PostTipoMedico): Call<List<Especialista>>


}