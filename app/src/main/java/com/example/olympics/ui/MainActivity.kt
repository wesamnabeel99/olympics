package com.example.olympics.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.olympics.R
import com.example.olympics.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    private var binding:ActivityMainBinding?=null
    private val homeFragment = HomeFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Olympics)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(requireNotNull(binding).root)
        setup()
    }

    private fun setup() {
        addFragment(homeFragment)
        parseTheData()
    }
    private fun addFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container,fragment)
        transaction.commit()
    }

    private fun parseTheData() {
       val inputStream = assets.open("tokyo_2021.csv")
       val buffer = BufferedReader(InputStreamReader(inputStream))
       buffer.forEachLine {
           Log.v ("MAIN_ACTIVITY",it)
       }
    }

}