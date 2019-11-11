package com.example.dqv.beans

import java.sql.Timestamp

open class Funcionario : Pessoa {
    var dataAdmissao : Timestamp? = null

    constructor(id: Int, email: String, pass: String, nome:String, rg: String, cpf: String, telefone: String,
                sexo: Sexo, estadoCivil: EstadoCivil, dataNascimento: Timestamp,
                dataInicio: Timestamp, dataFim: Timestamp, coordenador: Boolean,
                endereco: Endereco, dataAdmissao : Timestamp) : super(id, email, pass, nome, rg, cpf, telefone,
                sexo, estadoCivil, dataNascimento, dataInicio, dataFim, coordenador, endereco){
        this.dataAdmissao = dataAdmissao
    }
}