package com.example.nammaraste.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.nammaraste.R
import com.example.nammaraste.database.AppDatabase
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        val etEmail =
            findViewById<EditText>(R.id.etEmail)

        val etPassword =
            findViewById<EditText>(R.id.etPassword)

        val btnLogin =
            findViewById<Button>(R.id.btnLogin)

        val db =
            AppDatabase.getDatabase(this)

        btnLogin.setOnClickListener {

            val email =
                etEmail.text.toString()

            val password =
                etPassword.text.toString()

            lifecycleScope.launch {

                val user =
                    db.userDao().login(
                        email,
                        password
                    )

                runOnUiThread {

                    if (user != null) {

                        startActivity(

                            Intent(
                                this@LoginActivity,
                                HomeActivity::class.java
                            )
                        )

                        finish()

                    } else {

                        Toast.makeText(
                            this@LoginActivity,
                            "Invalid Credentials",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
}