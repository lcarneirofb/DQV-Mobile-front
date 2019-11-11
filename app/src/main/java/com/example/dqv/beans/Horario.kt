package com.example.dqv.beans

import java.time.LocalTime

class Horario {
    var id: Int? = null
    var horaInico:LocalTime? =null
    var horaFim:LocalTime? =null
    var disponivel: Boolean? = null
    var diaria:Diaria? = null
    var consulta:Consulta? =null

    constructor(id: Int, horaInico:LocalTime, horaFim:LocalTime, disponivel: Boolean, diaria:Diaria, consulta:Consulta){
        this.id=id
        this.horaInico=horaInico
        this.horaFim=horaFim
        this.disponivel=disponivel
        this.diaria=diaria
        this.consulta=consulta
    }
}