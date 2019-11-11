package com.example.dqv.beans

class Consulta {
    var id: Int? = null
    var viaTelefone:Boolean? = null
    var cancelada:Boolean? = null
    var status:Boolean? = null
    var observacao:String? = null
    var avaliacao:String? = null
    var procedimentoRealizado:String? = null

    var especialista:Especialista? = null
    var horario:Horario? = null

    constructor(id: Int, viaTelefone:Boolean, cancelada:Boolean, status:Boolean, observacao:String,
                avaliacao:String, procedimentoRealizado:String, especialista:Especialista, horario:Horario){
        this.id=id
        this.viaTelefone=viaTelefone
        this.cancelada=cancelada
        this.status=status
        this.observacao=observacao
        this.avaliacao=avaliacao
        this.procedimentoRealizado=procedimentoRealizado
        this.horario=horario
    }




}