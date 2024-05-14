package com.flius.guidy

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.flius.guidy.R.id

class MainActivity : AppCompatActivity() {
    private lateinit var tv_LoginEmail: EditText
    private lateinit var tv_LoginPassword: EditText
    private lateinit var bt_Login: Button
    private lateinit var bt_GoToSignUp: Button
    private lateinit var bt_local: Button
    private var local = false

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tv_LoginEmail = findViewById(id.tv_LoginEmail)
        tv_LoginPassword = findViewById(id.tv_LoginPassword)
        bt_Login = findViewById(id.bt_Login)
        bt_GoToSignUp = findViewById(id.bt_GoToSignUp)
        bt_local = findViewById(id.bt_local)
        bt_local.setOnClickListener {
            local = !local
            bt_local.text = if (local) "내국인" else "외국인"
        }
        bt_Login.setOnClickListener {
            // 등록 페이지로 이동함
            if (local) {
                val intent = Intent(this, RegistrationActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, ProfileListActivity::class.java)
                startActivity(intent)
            }
        }

        bt_GoToSignUp.setOnClickListener {
            // 회원가입 페이지로 이동
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}
