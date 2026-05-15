package com.example.nammaraste.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.nammaraste.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home)

        val btnReport =
            findViewById<Button>(R.id.btnReport)

        btnReport.setOnClickListener {

            startActivity(

                Intent(
                    this,
                    ReportActivity::class.java
                )
            )
        }
    }
}