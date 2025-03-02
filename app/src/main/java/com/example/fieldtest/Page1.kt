package com.example.fieldtest

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Page1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page1)

        val etFirstName = findViewById<EditText>(R.id.etFirstName)
        val etLastName = findViewById<EditText>(R.id.etLastName)
        val etPhone = findViewById<EditText>(R.id.etPhone)
        val etAge = findViewById<EditText>(R.id.etAge)
        val etReligion = findViewById<EditText>(R.id.etReligion)
        val btnNext = findViewById<Button>(R.id.btnNext)

        btnNext.setOnClickListener {
            val firstName = etFirstName.text.toString().trim()
            val lastName = etLastName.text.toString().trim()
            val phone = etPhone.text.toString().trim()
            val age = etAge.text.toString().trim()
            val religion = etReligion.text.toString().trim()

            try {
                when {
                    firstName.isEmpty() -> showToast("First Name can't be empty")
                    lastName.isEmpty() -> showToast("Last Name can't be empty")
                    phone.isEmpty() || phone.length != 11 -> showToast("Phone must be 11 digits")
                    age.isEmpty() || age.toInt() !in 1..200 -> showToast("Invalid Age")
                    religion.isEmpty() -> showToast("Religion can't be empty")
                    else -> {
                        val intent = Intent(this, Page2::class.java)
                        startActivity(intent)
                    }
                }
            } catch (e: Exception) {
                showToast("Invalid Age")
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
