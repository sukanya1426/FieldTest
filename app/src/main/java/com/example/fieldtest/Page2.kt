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

class Page2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)

        val streetAddressEditText = findViewById<EditText>(R.id.streetAddressEditText)
        val cityEditText = findViewById<EditText>(R.id.cityEditText)
        val stateEditText = findViewById<EditText>(R.id.stateEditText)
        val postalCodeEditText = findViewById<EditText>(R.id.postalCodeEditText)
        val countryEditText = findViewById<EditText>(R.id.countryEditText)
        val nextButton = findViewById<Button>(R.id.nextButton)

        nextButton.setOnClickListener {
            val streetAddress = streetAddressEditText.text.toString().trim()
            val city = cityEditText.text.toString().trim()
            val state = stateEditText.text.toString().trim()
            val postalCode = postalCodeEditText.text.toString().trim()
            val country = countryEditText.text.toString().trim()

            when {
                streetAddress.isEmpty() -> showToast("Street Address can't be empty")
                city.isEmpty() -> showToast("City can't be empty")
                state.isEmpty() -> showToast("State can't be empty")
                postalCode.isEmpty() -> showToast("Postal Code can't be empty")
                country.isEmpty() -> showToast("Country can't be empty")
                else -> {
                    val intent = Intent(this, Page3::class.java)
                    startActivity(intent)
                }
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
