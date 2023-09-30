package com.geekbrains.myfirsttests.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.geekbrains.myfirsttests.R
import com.geekbrains.myfirsttests.databinding.ActivityMainBinding
import com.geekbrains.myfirsttests.utils.EmailValidator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val emailValidator = EmailValidator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setViewsProperties()
    }

    private fun setViewsProperties() {
        with(binding) {
            emailInput.addTextChangedListener(emailValidator)

            saveButton.setOnClickListener {
                var textToShow = ""

                if (emailValidator.isValid) {
                    textToShow = getString(R.string.valid_email)
                } else {
                    val textToShow = getString(R.string.invalid_email)
                    emailInput.error = textToShow
                }

                Toast.makeText(this@MainActivity, textToShow, Toast.LENGTH_SHORT).show()
            }
        }
    }
}