package com.example.dqv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.dqv.API.APICaller
import com.example.dqv.API.RetrofitInitializer
import com.example.dqv.beans.*
import com.example.dqv.services.DQV
import com.example.dqv.services.ServiceBuilder
import com.example.dqv.services.models.LoginResponse
import com.example.dqv_front.MenuActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.*
import java.sql.Time
import java.sql.Timestamp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login.setOnClickListener {

            val user: String = inpt_usuario.text.toString()
            val pass: String = inpt_senha.text.toString()


            //Verificacoes dos campos de login e senha
            if(user.isNullOrEmpty()){
                Toast.makeText(this, R.string.loginWarning, Toast.LENGTH_SHORT).show()
                txt_usuario.requestFocus()
                return@setOnClickListener
            }

            if(pass.isNullOrEmpty()){
                Toast.makeText(this, R.string.senhaWarning, Toast.LENGTH_SHORT).show()
                txt_senha.requestFocus()
                return@setOnClickListener
            }


            //começo da operacao de login

            var login: Login = Login(user,pass)

            RetrofitInitializer()
            val call = RetrofitInitializer().loginService().authenticateUser(login)
            call.enqueue(object: Callback<Pessoa?> {
                override fun onResponse(call: Call<Pessoa?>, response: Response<Pessoa?>) {
                    response?.body()?.let {
                        val pessoa: Pessoa = it

                        if(pessoa.id == null || pessoa.nome == null){
                            Toast.makeText(applicationContext,R.string.userNotFound, Toast.LENGTH_SHORT).show()
                            return
                        }

                        println(pessoa.nome)
                        println(pessoa?.endereco?.logradouro)

                        val intent = Intent(applicationContext,MenuActivity::class.java)
                        startActivity(intent)
                    }
                }

                override fun onFailure(call: Call<Pessoa?>, t: Throwable) {
                    Toast.makeText(applicationContext,t?.message, Toast.LENGTH_SHORT).show()
                    println(t?.message)
                    Toast.makeText(applicationContext, "Algo de errado não está certo, "+
                            "Estudantes sedentos estão trabalhando para resolver o seu problema, NTI PLS HALP", Toast.LENGTH_SHORT).show()
                }
            })

            //fim login


            //começo consultas



            //fim consultas


        }
    }

}
