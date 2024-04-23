package com.intprog.random

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val students = mutableListOf<Student>()
    private val studentIds = mutableListOf<String>()
    private lateinit var adapter: RecyclerViewAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        adapter = RecyclerViewAdapter(studentIds) { selectedId ->
            val selectedStudent = students.find { it.id == selectedId }
            selectedStudent?.let {
                val intent = Intent(this, StudentDetailsActivity::class.java)
                intent.putExtra("id", selectedStudent.id)
                intent.putExtra("name", selectedStudent.name)
                intent.putExtra("age", selectedStudent.age)
                intent.putExtra("status", selectedStudent.status)
                startActivity(intent)
            }
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val idEditText = findViewById<EditText>(R.id.idNumber)
        val nameEditText = findViewById<EditText>(R.id.Name)
        val ageEditText = findViewById<EditText>(R.id.age)
        val statusEditText = findViewById<EditText>(R.id.status)
        val addBtn = findViewById<Button>(R.id.addButton)

        addBtn.setOnClickListener {
            val id = idEditText.text.toString()
            val name = nameEditText.text.toString()
            val age = ageEditText.text.toString().toIntOrNull() ?: 0
            val gender = statusEditText.text.toString()
            val student = Student(id, name, age, gender)
            students.add(student)
            studentIds.add(id)
            adapter.notifyDataSetChanged()
        }
    }
}