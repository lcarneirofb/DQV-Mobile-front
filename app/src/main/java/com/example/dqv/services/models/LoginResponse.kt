package com.example.dqv.services.models

import com.example.dqv.beans.Endereco
import com.example.dqv.beans.EstadoCivil
import com.example.dqv.beans.Sexo
import java.sql.Timestamp

data class LoginResponse(val id: Int, val email: String, val pass: String, val nome:String, val rg: String,
                         val cpf: String, val telefone: String, val sexo: Sexo, val estadoCivil: EstadoCivil,
                         val dataNascimento: Timestamp, val endereco: Endereco)