package com.example.fieldtest

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.content.Intent
import android.widget.*

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvRegister = findViewById<TextView>(R.id.tvRegister)

        val defaultEmail = "default@gmail.com"
        val defaultPassword = "password123"
        val defaultUsername = "default"

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val username = etUsername.text.toString().trim()

            when {
                email.isEmpty() -> showToast("Email can't be empty")
                password.isEmpty() -> showToast("Password can't be empty")
                username.isEmpty() -> showToast("Username can't be empty")
                email != defaultEmail -> showToast("Invalid Email")
                password != defaultPassword -> showToast("Invalid Password")
                username != defaultUsername -> showToast("Invalid Username")
                else -> {
                    val intent = Intent(this, Page1::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }

        tvRegister.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
