package com.flius.guidy

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var editText: EditText
    private lateinit var adapter: ArrayAdapter<String>
    private val listItems = mutableListOf("때니", "빡기성", "민재몬", "이준상")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        listView = findViewById(R.id.PostListView)
        editText = findViewById(R.id.tv_addItem)
        val addButton: Button = findViewById(R.id.bt_profileAdd)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("detail", listItems[position])
            startActivity(intent)
        }
        addButton.setOnClickListener {
            val newItem = editText.text.toString()
            if (newItem.isNotEmpty()) {
                listItems.add(newItem)
                adapter.notifyDataSetChanged()
                editText.setText("")


            }
        }
    }
}

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val textView = findViewById<TextView>(R.id.tv_profile)
        val detailText = intent.getStringExtra("detail")
        textView.text = detailText
    }
}