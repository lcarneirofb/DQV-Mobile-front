package com.example.dqv.beans

class Endereco {


    var id: Int? = null
    var cep: String? = null
    var logradouro: String? = null
    var numero:Int? = null
    var cidade: String? = null
    var uf: String? = null

    constructor( id: Int, cep: String, logradouro: String, numero:Int , cidade: String, uf: String){
        this.id = id
        this.cep = cep
        this.logradouro = logradouro
        this.numero = numero
        this.cidade = cidade
        this.uf = uf
    }







}