package com.example.fieldtest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Page4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page4)

        val companyNameEditText = findViewById<EditText>(R.id.companyNameEditText)
        val jobTitleEditText = findViewById<EditText>(R.id.jobTitleEditText)
        val yearsOfExperienceEditText = findViewById<EditText>(R.id.yearsOfExperienceEditText)
        val salaryEditText = findViewById<EditText>(R.id.salaryEditText)
        val nextButton = findViewById<Button>(R.id.nextButton)

        nextButton.setOnClickListener {
            val companyName = companyNameEditText.text.toString().trim()
            val jobTitle = jobTitleEditText.text.toString().trim()
            val yearsOfExperience = yearsOfExperienceEditText.text.toString().trim()
            val salary = salaryEditText.text.toString().trim()

            try {
                when {
                    companyName.isEmpty() -> showToast("Company Name can't be empty")
                    jobTitle.isEmpty() -> showToast("Job Title can't be empty")
                    yearsOfExperience.isEmpty() -> showToast("Years of Experience can't be empty")
                    salary.isEmpty() -> showToast("Salary can't be empty")
                    salary.toInt() < 0 -> showToast("Invalid Salary")
                    yearsOfExperience.toInt() < 0 -> showToast("Invalid Years of Experience")
                    else -> {
                        val intent = Intent(this, Page5::class.java)
                        startActivity(intent)
                    }
                }
            } catch (e: Exception) {
                showToast("Invalid Salary or Years of Experience")
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
