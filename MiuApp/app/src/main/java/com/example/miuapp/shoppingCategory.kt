package com.example.miuapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.miuapp.databinding.ActivityShopBinding


class shoppingCategory : AppCompatActivity() {
    private lateinit var binding:ActivityShopBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShopBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val rmsg = binding.userEmail
        val intent = intent
        val output = intent.getStringExtra("info")
        rmsg.text = output

    }
}