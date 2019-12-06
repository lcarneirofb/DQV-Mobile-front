package com.example.dqv.beans

import java.sql.Timestamp

class Servidor : Funcionario {
    var situacao:Situacao? = null

    constructor(id: Int, email: String, pass: String, nome:String, rg: String, cpf: String, telefone: String,
                sexo: Sexo, estadoCivil: EstadoCivil, dataNascimento: String,
                dataInicio: String, dataFim: String, coordenador: Boolean,
                endereco: Endereco, dataAdmissao : Timestamp,situacao:Situacao
    ) : super(id, email, pass, nome, rg, cpf, telefone,
        sexo, estadoCivil, dataNascimento, dataInicio, dataFim, coordenador, endereco,dataAdmissao){
        this.situacao=situacao
    }
}