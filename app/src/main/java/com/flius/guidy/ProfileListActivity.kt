package com.flius.guidy

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.flius.guidy.R.id

class ProfileListActivity : AppCompatActivity() {
    private lateinit var profileListView: ListView
    private lateinit var adapter: ArrayAdapter<String>
    private val dataManager = ListDataManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foreignlist)

        profileListView = findViewById(id.PostListView)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dataManager.getItems())
        profileListView.adapter = adapter

        profileListView.setOnItemClickListener { _, _, position, _ ->
            when (position) {
                0 -> startActivity(Intent(this, PostActivity1::class.java))
                1 -> startActivity(Intent(this, PostActivity2::class.java))
                2 -> startActivity(Intent(this, PostActivity3::class.java))
                3 -> startActivity(Intent(this, PostActivity4::class.java))
            }
        }
    }
}

class ListDataManager {
    private val items = mutableListOf("때니", "빡기성", "민재몬", "이준상")
    fun getItems(): List<String> {
        return items
    }
}
