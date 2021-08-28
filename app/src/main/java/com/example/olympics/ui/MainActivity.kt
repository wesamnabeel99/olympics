package com.example.olympics.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.olympics.R
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Olympics)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        parseTheData()
    }

    private fun parseTheData() {
       val inputStream = assets.open("tokyo_2021.csv")
       val buffer = BufferedReader(InputStreamReader(inputStream))
       buffer.forEachLine {
           Log.v ("MAIN_ACTIVITY",it)
       }
    }
}