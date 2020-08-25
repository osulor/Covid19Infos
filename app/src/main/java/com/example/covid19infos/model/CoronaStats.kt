package com.example.covid19infos.model

data class CoronaStats(
    val Countries: List<Country>,
    val Date: String,
    val Global: Global
)