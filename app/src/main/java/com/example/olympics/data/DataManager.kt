package com.example.olympics.data

import com.example.olympics.data.domain.Country


object DataManager {
    private val countriesList  = mutableListOf<Country>()

    val countries : List<Country>
        get() = countriesList

    fun addCountry(country: Country) {
        countriesList.add(country)
    }

}