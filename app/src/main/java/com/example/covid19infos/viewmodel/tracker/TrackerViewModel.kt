package com.example.covid19infos.viewmodel.tracker

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.covid19infos.model.tracker.CountryStats
import com.example.covid19infos.model.tracker.WorldStats
import com.example.covid19infos.repository.TrackerRepository
import com.example.covid19infos.util.ApiCallState
import kotlinx.coroutines.launch
import retrofit2.Response

class TrackerViewModel(private val trackerRepository: TrackerRepository) : ViewModel() {

    private val _worldStats : MutableLiveData<ApiCallState<WorldStats>> = MutableLiveData()
    val worldStats : LiveData<ApiCallState<WorldStats>>
        get() = _worldStats

    private val _countryStats: MutableLiveData<ApiCallState<CountryStats>> = MutableLiveData()
    val countryStats: LiveData<ApiCallState<CountryStats>>
        get() = _countryStats

    init {
        getWorldStats()
    }

    private fun getWorldStats() {
        viewModelScope.launch {
            _worldStats.value = ApiCallState.Loading()
           val response = trackerRepository.getWorldStats()
            handleWorldStatsReponse(response)
        }
    }

     fun getCountryStats(country: String){
        viewModelScope.launch {
            _countryStats.value = ApiCallState.Loading()
            val response = trackerRepository.getCountryStats(country)
            handleCountryStatsResponse(response)
        }
    }

    private fun handleWorldStatsReponse(response: Response<WorldStats>) : ApiCallState<WorldStats> {

        if(response.isSuccessful){

            response.body()?.let {resultResponse ->
                _worldStats.value = ApiCallState.Success(resultResponse)
                return ApiCallState.Success(resultResponse)
            }
        }

        return ApiCallState.Error(response.message())
    }

    private fun handleCountryStatsResponse(response: Response<CountryStats>) : ApiCallState<CountryStats>{

        if(response.isSuccessful){
            response.body()?.let {
                _countryStats.value = ApiCallState.Success(it)
                return ApiCallState.Success(it)
            }
        }

        return ApiCallState.Error(response.message())
    }
}