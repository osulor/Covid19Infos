package com.example.covid19infos.remote.service

import com.example.covid19infos.model.tracker.WorldStats
import retrofit2.Response
import retrofit2.http.GET

interface TrackerApiService {

    @GET("/world/total?")
    suspend fun getWorldStats() : Response<WorldStats>

}