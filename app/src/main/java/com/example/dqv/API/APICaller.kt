package com.example.dqv.API

import android.widget.Toast
import com.example.dqv.beans.Login
import com.example.dqv.beans.Pessoa
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class APICaller {
    var pessoa: Pessoa? = null

    constructor(){

    }
    private fun configPessoa(pessoa: Pessoa){
        this.pessoa = pessoa
    }

    fun login (email: String, pass: String) : Pessoa {
        var login: Login = Login(email,pass)
        RetrofitInitializer()
        val call = RetrofitInitializer().loginService().authenticateUser(login)
        call.enqueue(object: Callback<Pessoa?> {
            override fun onResponse(call: Call<Pessoa?>, response: Response<Pessoa?>) {
                response?.body()?.let {
                    val pessoa: Pessoa = it
                    println(pessoa.nome)
                    println(pessoa?.endereco?.logradouro)
                    configPessoa(pessoa)
                }
            }

            override fun onFailure(call: Call<Pessoa?>, t: Throwable) {
                println(t?.message)
            }
        })
        return this.pessoa!!
    }
}