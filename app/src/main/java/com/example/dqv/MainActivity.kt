package com.example.dqv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.dqv_front.MenuActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login.setOnClickListener {
            val user: String = inpt_usuario.toString()
            val pass: String = inpt_senha.toString()
            val message: String = "User" + user + "logged in with password " + pass
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }

}
