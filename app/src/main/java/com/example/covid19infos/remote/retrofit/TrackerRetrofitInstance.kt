package com.example.covid19infos.remote.retrofit

import com.example.covid19infos.remote.service.NewsApiService
import com.example.covid19infos.remote.service.TrackerApiService
import com.example.covid19infos.util.Constants.BASE_URL
import com.example.covid19infos.util.Constants.TRACKER_BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TrackerRetrofitInstance {

    companion object{
        private val retrofitInstance by lazy {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

            Retrofit.Builder()
                .baseUrl(TRACKER_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

        }

        val API_TRACKER: TrackerApiService by lazy {
            retrofitInstance.create(TrackerApiService::class.java)
        }

    }

}