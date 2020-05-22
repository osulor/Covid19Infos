package com.example.covid19infos.repository

import com.example.covid19infos.model.News
import com.example.covid19infos.remote.RetrofitInstance
import retrofit2.Response

class NewsRepository {

    suspend fun getNews(searchQuery: String, pageNumber: Int): Response<News>{
        return RetrofitInstance.api.getNews(searchQuery,pageNumber)
    }

}