package com.example.nammaraste.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reports")

data class Report(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val ticketId: String,

    val type: String,

    val imagePath: String,

    val latitude: Double,

    val longitude: Double,

    val time: String,

    val status: String
)