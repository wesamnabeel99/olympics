package com.example.olympics.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.olympics.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Olympics)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}