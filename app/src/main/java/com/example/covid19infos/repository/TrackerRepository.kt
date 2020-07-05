package com.example.covid19infos.repository

import com.example.covid19infos.model.tracker.WorldStats
import com.example.covid19infos.remote.retrofit.TrackerRetrofitInstance
import com.example.covid19infos.remote.service.TrackerApiService
import retrofit2.Response

class TrackerRepository : TrackerApiService {
    override suspend fun getWorldStats(): Response<WorldStats> {
       return TrackerRetrofitInstance.API_TRACKER.getWorldStats()
    }
}