package com.example.olympics.data.domain

data class Country (
    val rank :Int,
    val country :String,
    val gold:Int,
    val silver:Int,
    val bronze:Int,
    val total:Int,
    val rankByTotal:Int,
    val iso:String
        )