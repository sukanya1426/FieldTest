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

class Page5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page5)

        val overallExperienceEditText = findViewById<EditText>(R.id.overallExperienceEditText)
        val suggestionsEditText = findViewById<EditText>(R.id.suggestionsEditText)
        val ratingEditText = findViewById<EditText>(R.id.ratingEditText)
        val additionalCommentsEditText = findViewById<EditText>(R.id.additionalCommentsEditText)
        val submitButton = findViewById<Button>(R.id.submitButton)

        submitButton.setOnClickListener {
            val overallExperience = overallExperienceEditText.text.toString().trim()
            val suggestions = suggestionsEditText.text.toString().trim()
            val rating = ratingEditText.text.toString().trim()
            val additionalComments = additionalCommentsEditText.text.toString().trim()

            try {
                when {
                    overallExperience.isEmpty() -> showToast("Overall Experience can't be empty")
                    suggestions.isEmpty() -> showToast("Suggestions can't be empty")
                    rating.isEmpty() -> showToast("Rating can't be empty")
                    additionalComments.isEmpty() -> showToast("Additional Comments can't be empty")
                    rating.toInt() !in 1..5 -> showToast("Invalid Rating. Please enter a value between 1 and 5")
                    else -> {
                        val intent = Intent(this, FinalPage::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            } catch (e: Exception) {
                showToast("Invalid Rating")
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
