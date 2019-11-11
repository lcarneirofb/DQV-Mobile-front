package com.example.dqv.beans

import java.sql.Timestamp

class AgendamentoConsulta {
    var id: Int? = null
    var horaMarcado:Timestamp? = null
    var paciente:Pessoa? = null
    var servidor:Servidor? = null
    var consulta:Consulta? = null

    constructor(id: Int, horaMarcado:Timestamp, paciente:Pessoa, servidor:Servidor, consulta:Consulta){
        this.id=id
        this.horaMarcado=horaMarcado
        this.paciente=paciente
        this.servidor=servidor
        this.consulta=consulta
    }
}