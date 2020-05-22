package com.example.covid19infos.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.covid19infos.model.News
import com.example.covid19infos.repository.NewsRepository
import com.example.covid19infos.util.ApiCallState
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    val coronaNews: MutableLiveData<ApiCallState<News>> = MutableLiveData()
    val pageNumber = 1

    init {
        getCoronaNews("covid-19")
    }

    fun getCoronaNews(query: String) {
        viewModelScope.launch {
            coronaNews.value = ApiCallState.Loading()
            val response =  newsRepository.getNews(query,pageNumber)
            handleCoronaNewsReponse(response)
        }
    }

    fun handleCoronaNewsReponse(response: Response<News>) : ApiCallState<News>{

        if(response.isSuccessful){

            response.body()?.let {resultResponse ->
                coronaNews.value = ApiCallState.Success(resultResponse)
                return ApiCallState.Success(resultResponse)
            }
        }

        return ApiCallState.Error(response.message())
    }

}