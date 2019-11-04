package com.example.dqv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.dqv.services.ServiceBuilder
import com.example.dqv_front.MenuActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login.setOnClickListener {

            val user: String = inpt_usuario.text.toString()
            val pass: String = inpt_senha.text.toString()

            println(user)
            println(pass)
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


            //implementar Login

            //ServiceBuilder.retrofit.autenticateUser()

            val message: String = "User" + user + "logged in with password " + pass
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }

}
