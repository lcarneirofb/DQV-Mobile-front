package com.example.dqv.services.storage

import android.content.Context
import android.R.id.edit
import android.content.SharedPreferences
import com.example.dqv.beans.Pessoa


class SharedPrefManager {

    private val SHARED_PREF_NAME = "dqv_shared_preff"

    private var mInstance: SharedPrefManager? = null
    private var DQVCtx: Context? = null


    constructor(DQVCtx: Context){
        this.DQVCtx = DQVCtx
    }

    @Synchronized
    fun getInstance(mCtx: Context): SharedPrefManager {
        if (mInstance == null) {
            mInstance = SharedPrefManager(mCtx)
        }
        return mInstance as SharedPrefManager
    }

    fun saveUser(pessoa: Pessoa) {

        val sharedPreferences = DQVCtx!!.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences!!.edit()

        pessoa.id?.let { editor.putInt("id", it)}
        pessoa.email?.let { editor.putString("email", it)}
        pessoa.pass?.let { editor.putString("pass", it)}
        pessoa.nome?.let { editor.putString("nome", it)}
        pessoa.rg?.let { editor.putString("rg", it)}
        pessoa.cpf?.let { editor.putString("cpf", it)}
        pessoa.telefone?.let { editor.putString("telefone", it)}
        pessoa.sexo?.let { editor.putString("sexo", it.toString())}
        pessoa.estadoCivil?.let {}
        pessoa.coordenador?.let { editor.putBoolean("coordenador",it) }

        editor.apply()


    }
}