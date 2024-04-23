package com.intprog.random

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val studentIds: MutableList<String>, private val clickListener: (String) -> Unit) : RecyclerView.Adapter<RecyclerViewAdapter.StudentViewHolder>() {

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val idView : TextView = itemView.findViewById(R.id.idHolder)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_itmes, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val currentId = studentIds[position]
        holder.idView.text = currentId
        holder.itemView.setOnClickListener { clickListener(currentId) }
    }

    override fun getItemCount(): Int {
        return studentIds.size
    }
}

data class Student (
    val id: String,
    val name: String,
    val age: Int,
    val status: String
)