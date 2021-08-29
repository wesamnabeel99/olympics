package com.example.olympics.data

import com.example.olympics.data.domain.Country

object DataManager {
    private val countriesList  = mutableListOf<Country>()

    fun addCountry(country: Country) {
        countriesList.add(country)
    }

}