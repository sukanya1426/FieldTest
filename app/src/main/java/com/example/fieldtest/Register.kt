package com.example.fieldtest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val emailInput = findViewById<EditText>(R.id.emailInput)
        val passwordInput = findViewById<EditText>(R.id.passwordInput)
        val usernameInput = findViewById<EditText>(R.id.usernameInput)
        val registerButton = findViewById<Button>(R.id.registerButton)

        val emailRegex = "^[a-zA-Z0-9+_.-]+@gmail\\.com$".toRegex()

        registerButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()
            val username = usernameInput.text.toString().trim()

            when {
                email.isEmpty() -> showToast("Email can't be empty")
                password.isEmpty() -> showToast("Password can't be empty")
                username.isEmpty() -> showToast("Username can't be empty")
                !emailRegex.matches(email) -> showToast("Invalid Email")
                password.length < 8 -> showToast("Password must be at least 8 characters")
                username.length < 6 -> showToast("Username must be at least 6 characters")
                else -> {
                    showToast("Registration Successful")
                    startActivity(Intent(this, Page1::class.java))
                    finish()
                }
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
