package com.example.covid19infos.repository

import com.example.covid19infos.model.news.News
import com.example.covid19infos.remote.retrofit.RetrofitInstance
import retrofit2.Response

class NewsRepository {

    suspend fun getNews(searchQuery: String, pageNumber: Int): Response<News>{
        return RetrofitInstance.API_NEWS.getNews(searchQuery,pageNumber)
    }

}