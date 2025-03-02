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

class Page3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page3)

        val cardNumberEditText = findViewById<EditText>(R.id.cardNumberEditText)
        val expiryDateEditText = findViewById<EditText>(R.id.expiryDateEditText)
        val cvvEditText = findViewById<EditText>(R.id.cvvEditText)
        val billingAddressEditText = findViewById<EditText>(R.id.billingAddressEditText)
        val accountHolderEditText = findViewById<EditText>(R.id.accountHolderEditText)
        val nextButton = findViewById<Button>(R.id.nextButton)

        nextButton.setOnClickListener {
            val cardNumber = cardNumberEditText.text.toString().trim()
            val expiryDate = expiryDateEditText.text.toString().trim()
            val cvv = cvvEditText.text.toString().trim()
            val billingAddress = billingAddressEditText.text.toString().trim()
            val accountHolder = accountHolderEditText.text.toString().trim()

            when {
                cardNumber.isEmpty() -> showToast("Card Number can't be empty")
                expiryDate.isEmpty() -> showToast("Expiry Date can't be empty")
                cvv.isEmpty() -> showToast("CVV can't be empty")
                billingAddress.isEmpty() -> showToast("Billing Address can't be empty")
                accountHolder.isEmpty() -> showToast("Account Holder can't be empty")
                else -> {
                    if(cvv.length > 3){
                        showToast("CVV can't be this long")
                    }else {
                        val intent = Intent(this, Page4::class.java)
                        startActivity(intent)
                    }
                }
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
