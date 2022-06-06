package com.doaibu.todoo.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.doaibu.todoo.database.TaskModel
import com.doaibu.todoo.databinding.AdapterTaskCompletedBinding

class TaskCompletedAdapter(
    var items: ArrayList<TaskModel>
):RecyclerView.Adapter<TaskCompletedAdapter.ViewHolder>() {

    class ViewHolder(val binding: AdapterTaskCompletedBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder (
        AdapterTaskCompletedBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
            )


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.textTask.text = item.task
        holder.binding.textTask.paintFlags = holder.binding.textTask.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        holder.binding.textDate.text = item.date.toString()
    }

    override fun getItemCount() = items.size
    }