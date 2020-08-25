package com.example.covid19infos.model.tracker

data class CountryStatsItem(
    val Confirmed: Int,
    val Country: String,
    val Date: String,
    val Deaths: Int,
    val Recovered: Int
)