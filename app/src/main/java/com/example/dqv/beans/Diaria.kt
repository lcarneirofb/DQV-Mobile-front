package com.example.dqv.beans

import java.sql.Timestamp

class Diaria {
    var id: Int? = null
    var diaria:Timestamp? = null
    var tempoConsulta: Int? = null
    var validado: Boolean? = null
    var aprovado: Boolean? = null
    var especialista:Especialista? = null

    constructor(id: Int,diaria:Timestamp, tempoConsulta: Int,validado: Boolean, aprovado: Boolean, especialista:Especialista){
        this.id = id
        this.diaria = diaria
        this.tempoConsulta = tempoConsulta
        this.validado=validado
        this.aprovado=aprovado
        this.especialista=especialista
    }
}