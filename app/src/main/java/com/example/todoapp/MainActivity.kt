package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import java.lang.reflect.Array
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var nome:MutableList<String> = mutableListOf()
    private val adapter = CustomAdapter(nome)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView:RecyclerView = findViewById(R.id.recyclerView)
        val meditText:EditText = findViewById(R.id.editTextTextPersonName)
        val button: Button = findViewById(R.id.button)
        recyclerView.adapter = adapter

        val layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
        button.setOnClickListener {
            val index = Random.nextInt(8)
            nome.add(meditText.text.toString())
            println(nome)
            adapter.notifyItemInserted(index)
            adapter.notifyDataSetChanged()

        }
    }

}