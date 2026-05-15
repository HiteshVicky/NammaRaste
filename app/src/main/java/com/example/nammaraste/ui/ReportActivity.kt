package com.example.nammaraste.ui

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nammaraste.R

class ReportActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_report)

        imageView =
            findViewById(R.id.imageView)

        val btnCapture =
            findViewById<Button>(R.id.btnCapture)

        val spinnerIssue =
            findViewById<Spinner>(R.id.spinnerIssue)

        val issues = arrayOf(

            "Pothole",

            "Street Light",

            "Garbage",

            "Road Damage"
        )

        spinnerIssue.adapter = ArrayAdapter(

            this,

            android.R.layout.simple_spinner_dropdown_item,

            issues
        )

        btnCapture.setOnClickListener {

            val intent =
                Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            startActivityForResult(intent, 100)
        }
    }

    override fun onActivityResult(

        requestCode: Int,

        resultCode: Int,

        data: Intent?
    ) {

        super.onActivityResult(

            requestCode,

            resultCode,

            data
        )

        if (

            requestCode == 100 &&
            resultCode == Activity.RESULT_OK
        ) {

            val photo =
                data?.extras?.get("data") as Bitmap

            imageView.setImageBitmap(photo)

            Toast.makeText(

                this,

                "Issue Submitted Successfully",

                Toast.LENGTH_LONG

            ).show()
        }
    }
}