package com.flius.guidy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RegistrationActivity : AppCompatActivity() {
    private lateinit var bt_Add: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        bt_Add = findViewById(R.id.bt_Add)
        bt_Add.setOnClickListener {
            // 결제 페이지로 이동
            val intent = Intent(this, PaymentActivity::class.java)
            startActivity(intent)
        }
    }
}