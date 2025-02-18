package com.vedis.trackexpense.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expenses")
data class Expense(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val category: String,
    val date: String,
    val amount: Double,
    val description: String?=null
)