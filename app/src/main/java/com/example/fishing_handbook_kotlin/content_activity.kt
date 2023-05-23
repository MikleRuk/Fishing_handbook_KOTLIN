package com.example.fishing_handbook_kotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class content_activity : AppCompatActivity (){

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_layout)
        var tvTitle_2 = findViewById<TextView>(R.id.tvTitle_2)
        var tvContent = findViewById<TextView>(R.id.tvContent)
        var im = findViewById<ImageView>(R.id.im)
        tvTitle_2.text = intent.getStringExtra("title")
        tvContent.text = intent.getStringExtra("content")
        im.setImageResource(intent.getIntExtra("image", R.drawable.som))
    }

}
