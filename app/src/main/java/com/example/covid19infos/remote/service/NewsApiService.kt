package com.example.covid19infos.remote.service

import com.example.covid19infos.model.news.News
import com.example.covid19infos.util.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("v2/everything")
    suspend fun getNews(
        @Query("q")
        searchQuery : String = "coronavirus",
        @Query("page")
        page : Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ) : Response<News>
}