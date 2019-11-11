package com.example.dqv.beans

class Login {
    var email: String? = null
    var pass: String? = null
    constructor(email: String, pass: String){
        this.email = email
        this.pass = pass
    }
}