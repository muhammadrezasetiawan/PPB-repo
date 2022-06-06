package com.doaibu.todoo.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "tableTask")
data class TaskModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val task: String,
    val completed: Boolean,
    val date: Long,
) : Serializable
