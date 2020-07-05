package com.example.covid19infos.model.news

import com.example.covid19infos.model.Article

data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)