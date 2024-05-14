package com.flius.guidy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var tv_LoginEmail: EditText
    private lateinit var tv_LoginPassword: EditText
    private lateinit var bt_Login: Button
    private lateinit var bt_GoToSignUp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tv_LoginEmail = findViewById(R.id.tv_LoginEmail)
        tv_LoginPassword = findViewById(R.id.tv_LoginPassword)
        bt_Login = findViewById(R.id.bt_Login)
        bt_GoToSignUp = findViewById(R.id.bt_GoToSignUp)

        bt_Login.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }

        bt_GoToSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}