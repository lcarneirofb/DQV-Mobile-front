package com.example.dqv.beans

import java.time.LocalTime

class Horario {
    var id: Int? = null
    var horaInico:String? =null
    var horaFim:String? =null
    var disponivel: Boolean? = null
    var diaria:Diaria? = null
    var consulta:Consulta? =null

    constructor(id: Int, horaInico:String, horaFim:String, disponivel: Boolean, diaria:Diaria, consulta:Consulta){
        this.id=id
        this.horaInico=horaInico
        this.horaFim=horaFim
        this.disponivel=disponivel
        this.diaria=diaria
        this.consulta=consulta
    }
}