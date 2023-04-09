package com.example.hello

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    private lateinit var setBackground: Button
    private lateinit var root: LinearLayout
    private lateinit var imagebtn: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setBackground = findViewById(R.id.setBackground)
        root = findViewById(R.id.root)

        setBackground.setOnClickListener{
            val randomColor = getRandomColor()
            root.setBackgroundColor(randomColor)
        }
        imagebtn = findViewById(R.id.miu_image)
        imagebtn.setOnClickListener{
            val rdColor = getRandomColor()
            imagebtn.setBackgroundColor(rdColor)
        }

    }
    private fun getRandomColor(): Int{
       val random = Random
        return Color.rgb(random.nextInt(256), random.nextInt(256),random.nextInt(256))
    }
}