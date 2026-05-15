package com.example.nammaraste.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.nammaraste.model.Report

@Dao
interface ReportDao {

    @Insert
    suspend fun insertReport(report: Report)

    @Query("SELECT * FROM reports WHERE ticketId = :ticket")
    suspend fun getReport(ticket: String): Report?
}