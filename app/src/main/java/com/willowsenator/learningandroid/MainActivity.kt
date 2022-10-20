package com.willowsenator.learningandroid

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val calculateButton = findViewById<Button>(R.id.buttonCalculate)
        val nextButton = findViewById<Button>(R.id.buttonNext)

        calculateButton.setOnClickListener {
            calculateAge()
        }

        nextButton.setOnClickListener{
            startActivity(Intent(this, SecondActivity::class.java))
            finish()
        }
    }


    private fun calculateAge(){
        val editTextBirthday = findViewById<EditText>(R.id.editTextBirthday).text
        if (editTextBirthday.isNotBlank()) {
            val birthdayYear = editTextBirthday.toString().toInt()
            val age = Calendar.getInstance().get(Calendar.YEAR) - birthdayYear
            val ageMessage = getString(R.string.textViewAgeText) + " " + age
            findViewById<TextView>(R.id.textViewAge).text = ageMessage
        }
        else{
            Toast.makeText(
                this,
                getString(R.string.toastErrorFromBirthYear),
                Toast.LENGTH_LONG
            ).show()
        }
    }
}

