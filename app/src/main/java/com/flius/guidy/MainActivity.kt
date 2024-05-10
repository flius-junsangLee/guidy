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
    private lateinit var addButton: Button
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
        addButton = findViewById(R.id.bt_profileAdd)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dataManager.getItems())
        ProfileListView.adapter = adapter

        ProfileListView.setOnItemClickListener { parent, view, position, id ->
           postDetail(position)
        }

        setupAddButtonListener()
    }
    private fun setupAddButtonListener() {
        addButton.setOnClickListener {
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
                val textView = findViewById<TextView>(R.id.tv_post1)
                textView.text = "게시 예시입니다1."
            }

            1 -> {
                setContentView(R.layout.activity_post2)
                val textView = findViewById<TextView>(R.id.tv_post2)
                textView.text = "게시물 예시입니다2."
                val button: Button = findViewById(R.id.bt_review1)
                button.setOnClickListener {
                    setContentView(R.layout.activity_review1) // 새 레이아웃 로드
                }
            }

            2 -> {
                setContentView(R.layout.activity_post3)
                val textView = findViewById<TextView>(R.id.tv_post2)
                textView.text = "게시물 예시입니다3."
            }
            3 ->{
                setContentView(R.layout.activity_post4)
                val textView = findViewById<TextView>(R.id.tv_post2)
                textView.text = "게시물 예시입니다4."

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
