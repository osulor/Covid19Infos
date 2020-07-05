package com.example.covid19infos.viewmodel.tracker

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.covid19infos.model.news.News
import com.example.covid19infos.model.tracker.WorldStats
import com.example.covid19infos.repository.TrackerRepository
import com.example.covid19infos.util.ApiCallState
import kotlinx.coroutines.launch
import retrofit2.Response

class TrackerViewModel(private val trackerRepository: TrackerRepository) : ViewModel() {

    private val _worldStats : MutableLiveData<ApiCallState<WorldStats>> = MutableLiveData()

    val worldStats : LiveData<ApiCallState<WorldStats>>
        get() = _worldStats

    init {
        getWorldStats()
    }

    fun getWorldStats() {
        viewModelScope.launch {
            _worldStats.value = ApiCallState.Loading()
           val response = trackerRepository.getWorldStats()
            handleWorldStatsReponse(response)
        }
    }

    fun handleWorldStatsReponse(response: Response<WorldStats>) : ApiCallState<WorldStats> {

        if(response.isSuccessful){

            response.body()?.let {resultResponse ->
                _worldStats.value = ApiCallState.Success(resultResponse)
                return ApiCallState.Success(resultResponse)
            }
        }

        return ApiCallState.Error(response.message())
    }
}