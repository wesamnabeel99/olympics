package com.example.olympics.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.olympics.R
import com.example.olympics.data.DataManager
import com.example.olympics.databinding.ActivityMainBinding
import com.example.olympics.util.DataParser
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    //region initializing variables
    private var binding:ActivityMainBinding?=null
    private val homeFragment = HomeFragment()
    //endregion

    //region onCreate function
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Olympics)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(requireNotNull(binding).root)
        setup()
    }
    //endregion

    //region setup
    /**
     * first function called after launching the main activity
     * @param nothing
     * @return Unit
     * @author Wesam N. Shawqi
     */
    private fun setup() {
        addFragment(homeFragment)
        parseTheData()
    }


    private fun parseTheData() {
       val inputStream = assets.open("tokyo_2021.csv")
       val buffer = BufferedReader(InputStreamReader(inputStream))
       val parser = DataParser ()
       buffer.forEachLine {
           DataManager.addCountry(parser.parse(it))
       }
    }
    //endregion

    //region add fragments
    /**
     * function that add fragment into the container
     * @param Fragment
     * @return Unit
     * @author Wesam N. Shawqi
     */
    private fun addFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container,fragment)
        transaction.commit()
    }
    //endregion
}