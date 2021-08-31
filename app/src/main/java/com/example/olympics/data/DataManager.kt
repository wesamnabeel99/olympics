package com.example.olympics.data

import com.example.olympics.data.domain.Country


object DataManager {
     val countriesList  = mutableListOf<Country>()
    fun addCountry(country: Country) {
        countriesList.add(country)
    }
    fun returnRandomCountry():Country {
        return countriesList[(0..92).random()]
    }

}