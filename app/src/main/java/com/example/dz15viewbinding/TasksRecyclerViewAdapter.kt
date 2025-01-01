package com.example.dz15viewbinding

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dz15viewbinding.databinding.TaskItemBinding

class TasksRecyclerViewAdapter(
    private val values: List<Task>
) : RecyclerView.Adapter<TasksRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            TaskItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.id.toString()
        holder.contentView.text = item.content
        holder.check.isChecked = item.check

        holder.check.setOnCheckedChangeListener { buttonView, isChecked ->
            item.check = isChecked
        }

    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: TaskItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content
        val check: CheckBox = binding.taskCb

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}