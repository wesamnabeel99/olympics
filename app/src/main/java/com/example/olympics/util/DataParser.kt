package com.example.olympics.util

import com.example.olympics.data.domain.Country

class DataParser {
    fun parse (countryData:String) : Country {
        val token =  countryData.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)".toRegex()) //regex to handle the values that has comma
        return Country (
            rank = token [Constants.ColumnIndex.RANK].toInt(),
            country = token [Constants.ColumnIndex.COUNTRY],
            gold = token [Constants.ColumnIndex.GOLD].toInt(),
            silver = token [Constants.ColumnIndex.SILVER].toInt(),
            bronze = token [Constants.ColumnIndex.BRONZE].toInt(),
            total = token [Constants.ColumnIndex.TOTAL].toInt(),
            rankByTotal = token [Constants.ColumnIndex.RANK_BY_TOTAL].toInt(),
            iso = token [Constants.ColumnIndex.ISO]
                )
    }
}