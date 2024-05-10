package com.flius.guidy

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
    private lateinit var textView: TextView
    private lateinit var ProfileListView: ListView
    private lateinit var addprofile: EditText
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var Button: Button
    private val dataManager = ListDataManager()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        profileList()

    }

    private fun profileList(){
        ProfileListView = findViewById(R.id.PostListView)
        addprofile = findViewById(R.id.tv_addItem)
        Button = findViewById(R.id.bt_profileAdd)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dataManager.getItems())
        ProfileListView.adapter = adapter

        ProfileListView.setOnItemClickListener { parent, view, position, id ->
           postDetail(position)
        }

        setupAddButtonListener()
    }
    private fun setupAddButtonListener() {
        Button.setOnClickListener {
            val newItem = addprofile.text.toString()
            if (newItem.isNotEmpty()) {
                dataManager.addItem(newItem)
                adapter.notifyDataSetChanged()
                addprofile.setText("")
            }
        }
    }
    private fun postDetail(position: Int){
        when (position) {
            0 -> {
                setContentView(R.layout.activity_post1)
                textView = findViewById<TextView>(R.id.tv_post1)
                textView.text = "게시물 예시입니다1."
                val Reviewbutton: Button = findViewById(R.id.bt_review1)
                Reviewbutton.text = "Review"
                Reviewbutton.setOnClickListener {
                    setContentView(R.layout.activity_review1)
                    textView = findViewById<TextView>(R.id.tv_review1)
                    textView.text = "리뷰페이지 예시."
                }
                val paybutton: Button = findViewById(R.id.bt_pay1)
                paybutton.text = "pay"
                paybutton.setOnClickListener {
                    setContentView(R.layout.activity_pay)
                    textView = findViewById<TextView>(R.id.tv_pay1)
                    textView.text = "결제페이지 예시"
                }
            }

            1 -> {
                setContentView(R.layout.activity_post2)
                textView = findViewById<TextView>(R.id.tv_post2)
                textView.text = "게시물 예시입니다2."
                val Reviewbutton: Button = findViewById(R.id.bt_review2)
                Reviewbutton.text = "Review"
                Reviewbutton.setOnClickListener {
                    setContentView(R.layout.activity_review2)
                    textView = findViewById<TextView>(R.id.tv_review2)
                    textView.text = "리뷰페이지 예시."
                }
                val paybutton: Button = findViewById(R.id.bt_pay2)
                paybutton.text = "pay"
                paybutton.setOnClickListener {
                    setContentView(R.layout.activity_pay)
                    textView = findViewById<TextView>(R.id.tv_pay1)
                    textView.text = "결제페이지 예시"
                }
            }

            2 -> {
                setContentView(R.layout.activity_post3)
                textView = findViewById<TextView>(R.id.tv_post3)
                textView.text = "게시물 예시입니다3."
                val Reviewbutton: Button = findViewById(R.id.bt_review3)
                Reviewbutton.text = "Review"
                Reviewbutton.setOnClickListener {
                    setContentView(R.layout.activity_review3)
                    textView = findViewById<TextView>(R.id.tv_review3)
                    textView.text = "리뷰페이지 예시."
                }
                val paybutton: Button = findViewById(R.id.bt_pay3)
                paybutton.text = "pay"
                paybutton.setOnClickListener {
                    setContentView(R.layout.activity_pay)
                    textView = findViewById<TextView>(R.id.tv_pay1)
                    textView.text = "결제페이지 예시"
                }
            }
            3 -> {
                setContentView(R.layout.activity_post4)
                textView = findViewById<TextView>(R.id.tv_post4)
                textView.text = "게시물 예시입니다4."
                val Reviewbutton: Button = findViewById(R.id.bt_review4)
                Reviewbutton.text = "Review"
                Reviewbutton.setOnClickListener {
                    setContentView(R.layout.activity_review4)
                    textView = findViewById<TextView>(R.id.tv_review4)
                    textView.text = "리뷰페이지 예시."
                }
                val paybutton: Button = findViewById(R.id.bt_pay4)
                paybutton.text = "pay"
                paybutton.setOnClickListener {
                    setContentView(R.layout.activity_pay)
                    textView = findViewById<TextView>(R.id.tv_pay1)
                    textView.text = "결제페이지 예시"
                }
            }
        }
    }
}
class ListDataManager {
    private val items = mutableListOf("때니", "빡기성", "민재몬", "이준상")

    fun addItem(newItem: String) {
        items.add(newItem)
    }

    fun getItems(): List<String> {
        return items
    }
}
