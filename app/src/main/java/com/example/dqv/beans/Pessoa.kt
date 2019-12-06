package com.example.dqv.beans

import java.sql.Time
import java.sql.Timestamp

open class Pessoa {

    var id: Int? = null
    var email: String? = null
    var pass: String? = null
    var nome: String? = null
    var rg: String? = null
    var cpf: String? = null
    var telefone: String? = null
    var sexo: Sexo? = null
    var estadoCivil: EstadoCivil? = null
    var dataNascimento: String? = null
    var dataInicio: String? = null
    var dataFim: String? = null
    var coordenador: Boolean? = null
    var endereco: Endereco? = null

    constructor(id: Int, email: String, pass: String, nome:String, rg: String, cpf: String, telefone: String,
                sexo: Sexo, estadoCivil: EstadoCivil, dataNascimento: String,
                dataInicio: String, dataFim: String, coordenador: Boolean,
                endereco: Endereco){
        this.id = id
        this.email = email
        this.pass = pass
        this.nome = nome
        this.rg = rg
        this.cpf = cpf
        this.telefone = telefone
        this.sexo = sexo
        this.estadoCivil = estadoCivil
        this.dataNascimento = dataNascimento
        this.dataInicio = dataInicio
        this.dataFim = dataFim
        this.coordenador = coordenador
        this.endereco = endereco
    }


}