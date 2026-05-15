package com.example.nammaraste.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.nammaraste.MainActivity
import com.example.nammaraste.R
import com.example.nammaraste.database.AppDatabase
import com.example.nammaraste.model.User
import kotlinx.coroutines.launch

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_signup)

        val etUsername =
            findViewById<EditText>(R.id.etUsername)

        val etEmail =
            findViewById<EditText>(R.id.etEmail)

        val etPassword =
            findViewById<EditText>(R.id.etPassword)

        val btnSignup =
            findViewById<Button>(R.id.btnSignup)

        val db =
            AppDatabase.getDatabase(this)

        btnSignup.setOnClickListener {

            val username =
                etUsername.text.toString().trim()

            val email =
                etEmail.text.toString().trim()

            val password =
                etPassword.text.toString().trim()

            if (
                username.isEmpty() ||
                email.isEmpty() ||
                password.isEmpty()
            ) {

                Toast.makeText(
                    this,
                    "Fill all fields",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            lifecycleScope.launch {

                db.userDao().insertUser(

                    User(
                        username = username,
                        email = email,
                        password = password
                    )
                )

                runOnUiThread {

                    Toast.makeText(
                        this@SignupActivity,
                        "Signup Successful",
                        Toast.LENGTH_SHORT
                    ).show()

                    startActivity(

                        Intent(
                            this@SignupActivity,
                            MainActivity::class.java
                        )
                    )

                    finish()
                }
            }
        }
    }
}