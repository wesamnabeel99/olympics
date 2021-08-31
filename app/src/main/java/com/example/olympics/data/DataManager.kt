package com.example.olympics.data

import com.example.olympics.data.domain.Country
import com.example.olympics.util.Properties


object DataManager {
    private val countriesList  = mutableListOf<Country>()

    val countries : List<Country>
        get() = countriesList.toList()

    /**
     * this function add country objects from the csv file and add it to countriesList
     * @param Country object given during parsing the data
     * @return Unit
     * @author Wesam N. Shawqi
     */
    fun addCountry(country: Country) {
        countriesList.add(country)
    }
    fun sortCountriesBy (property : Properties) :List<Country>
    = when (property) {
            Properties.TOTAL -> {
                countries.sortedByDescending { it.total }
            }
            Properties.GOLD -> {
                countries.sortedByDescending { it.gold }
            }
            Properties.SILVER -> {
                countries.sortedByDescending { it.silver }
            }
            Properties.BRONZE -> {
                countries.sortedByDescending { it.bronze }
            }
        }

}