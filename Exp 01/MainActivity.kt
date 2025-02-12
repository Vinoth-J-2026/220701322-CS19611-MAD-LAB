package com.example.madapp322

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val text: TextView=findViewById(R.id.result)

        val btn1 :Button=findViewById(R.id.btn1)
        val btn2 :Button=findViewById(R.id.btn2)
        val btn3 :Button=findViewById(R.id.btn3)

        btn1.setOnClickListener(){
            text.textSize=20f
        }
        btn2.setOnClickListener(){
            text.setTextColor(Color.parseColor("#FF0000"))
        }
        btn3.setOnClickListener(){
            text.setBackgroundColor(Color.parseColor("#FFF000"))
        }
    }
}