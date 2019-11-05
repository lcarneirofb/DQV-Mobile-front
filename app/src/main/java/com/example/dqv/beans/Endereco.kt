package com.example.dqv.beans

class Endereco {


    var id: Integer? = null
    var cep: String? = null
    var logradouro: String? = null
    var numero: Integer? = null
    var cidade: String? = null
    var uf: String? = null

    constructor(id: Integer, cep: String, logradouro: String, numero: Integer, cidade: String, uf: String){
        this.id = id
        this.cep = cep
        this.logradouro = logradouro
        this.numero = numero
        this.cidade = cidade
        this.uf = uf
    }







}