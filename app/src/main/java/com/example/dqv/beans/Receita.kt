package com.example.dqv.beans

import java.security.Timestamp

class Receita {
    var id: Int? = null
    var consulta:Consulta? = null
    var dataEmissao:String? = null
    var validade:String? = null
    var posologia:String? = null
    var descrição:String? = null
    var medicamento:String? = null
    var principioAtivo:String? = null

    constructor(id: Int, consulta:Consulta, dataEmissao:String, validade:String, posologia:String,
                descrição:String, medicamento:String, principioAtivo:String){
        this.id=id
        this.consulta=consulta
        this.dataEmissao=dataEmissao
        this.validade=validade
        this.posologia=posologia
        this.descrição=descrição
        this.medicamento=medicamento
        this.principioAtivo=principioAtivo
    }

}