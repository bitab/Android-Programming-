package com.example.miuapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.miuapp.databinding.ActivitySignupBinding

class SignUp : AppCompatActivity() {
    private lateinit var binding:ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val signupButton = binding.signupBtn
        signupButton.setOnClickListener {
            val firstName = binding.firstName.text.toString()
            val lastName = binding.lastName.text.toString()
            val newEmail = binding.newEmail.text.toString()
            val newPassword = binding.newPassword.text.toString()

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("fname", firstName)
            intent.putExtra("lname", lastName)
            intent.putExtra("newEmail", newEmail)
            intent.putExtra("newPassword", newPassword)

            if (firstName.isEmpty() || lastName.isEmpty() || newEmail.isEmpty() || newPassword.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()

            } else {
                startActivity(intent)
                return@setOnClickListener
            }
        }
    }
}