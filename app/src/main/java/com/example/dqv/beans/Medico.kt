package com.example.dqv.beans

import java.sql.Timestamp

class Medico : Especialista{
    var crm:String? = null
    var tipo:TipoMedico? = null

    constructor(id: Int, email: String, pass: String, nome:String, rg: String, cpf: String, telefone: String,
                sexo: Sexo, estadoCivil: EstadoCivil, dataNascimento: String,
                dataInicio: String, dataFim: String, coordenador: Boolean,
                endereco: Endereco, dataAdmissao : Timestamp, especialidade : Especialistas,
                responsavel : Pessoa, crm:String, tipo:TipoMedico
    ) : super(id, email, pass, nome, rg, cpf, telefone,
        sexo, estadoCivil, dataNascimento, dataInicio, dataFim, coordenador, endereco,dataAdmissao,especialidade,responsavel){
        this.crm = crm
        this.tipo = tipo
    }
}