package com.intprog.random

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class StudentDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        val idTextView = findViewById<TextView>(R.id.idTextView)
        val nameTextView = findViewById<TextView>(R.id.nameTextView)
        val ageTextView = findViewById<TextView>(R.id.ageTextView)
        val statusTextView = findViewById<TextView>(R.id.statusTextView)

        val id = intent.getStringExtra("id")
        val name = intent.getStringExtra("name")
        val age = intent.getIntExtra("age", 0)
        val status = intent.getStringExtra("status")

        idTextView.text = "ID: $id"
        nameTextView.text = "Name: $name"
        ageTextView.text = "Age: $age"
        statusTextView.text = "Status: $status"

    }
}