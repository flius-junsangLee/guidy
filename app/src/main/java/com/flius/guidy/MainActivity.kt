package com.flius.guidy

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.flius.guidy.R.id

class MainActivity : AppCompatActivity() {
    private lateinit var tv_LoginEmail: EditText
    private lateinit var tv_LoginPassword: EditText
    private lateinit var bt_Login: Button
    private lateinit var bt_GoToSignUp: Button
    private lateinit var bt_RadioLocal: RadioButton
    private lateinit var bt_RadioForeign: RadioButton
    private lateinit var rg_UserType: RadioGroup

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        rg_UserType = findViewById(R.id.rg_userType)
        bt_RadioLocal = findViewById(R.id.bt_radioLocal)
        bt_RadioForeign = findViewById(R.id.bt_radioForeign)
        tv_LoginEmail = findViewById(id.tv_LoginEmail)
        tv_LoginPassword = findViewById(id.tv_LoginPassword)
        bt_Login = findViewById(id.bt_Login)
        bt_GoToSignUp = findViewById(id.bt_GoToSignUp)


        bt_Login.setOnClickListener {
            val selectedUserType = rg_UserType.checkedRadioButtonId

            when (selectedUserType) {
                R.id.bt_radioLocal -> {
                    val intent = Intent(this, RegistrationActivity::class.java)
                    startActivity(intent)
                }
                R.id.bt_radioForeign -> {
                    val intent = Intent(this, ProfileListActivity::class.java)
                    startActivity(intent)
                }
            }
        }

        bt_GoToSignUp.setOnClickListener {
            // 회원가입 페이지로 이동
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}
