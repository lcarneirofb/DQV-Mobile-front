package com.example.dqv.beans

import java.sql.Timestamp

open class Especialista : Funcionario{
    var especialidade:Especialistas? = null
    var responsavel:Pessoa? = null

    constructor(id: Int, email: String, pass: String, nome:String, rg: String, cpf: String, telefone: String,
                sexo: Sexo, estadoCivil: EstadoCivil, dataNascimento: Timestamp,
                dataInicio: Timestamp, dataFim: Timestamp, coordenador: Boolean,
                endereco: Endereco, dataAdmissao : Timestamp, especialidade : Especialistas, responsavel : Pessoa
    ) : super(id, email, pass, nome, rg, cpf, telefone,
        sexo, estadoCivil, dataNascimento, dataInicio, dataFim, coordenador, endereco,dataAdmissao){
        this.especialidade = especialidade
        this.responsavel = responsavel

    }
}