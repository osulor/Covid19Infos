package com.example.covid19infos.remote.service

import com.example.covid19infos.model.tracker.CountryStats
import com.example.covid19infos.model.tracker.WorldStats
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TrackerApiService {

    @GET("/world/total?")
    suspend fun getWorldStats() : Response<WorldStats>

    @GET("/total/country/{country}")
    suspend fun getCountryStats(@Path("country") country: String) : Response<CountryStats>

}