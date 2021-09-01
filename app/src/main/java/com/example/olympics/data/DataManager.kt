package com.example.olympics.data

import com.example.olympics.data.domain.Country
import com.example.olympics.util.Property


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
    /**
     * this function sort the countries descending by the giving proberty
     * @param property : Property to sort the list by it
     * @return List of sorted countries
     * @author Wesam N. Shawqi
     */
    fun sortCountriesBy (property : Property) :List<Country>
    = when (property) {
            Property.TOTAL -> {
                countries.sortedByDescending { it.total }
            }
            Property.GOLD -> {
                countries.sortedByDescending { it.gold }
            }
            Property.SILVER -> {
                countries.sortedByDescending { it.silver }
            }
            Property.BRONZE -> {
                countries.sortedByDescending { it.bronze }
            }
        }

}