package com.example.covid19infos.viewmodel.tracker

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.covid19infos.repository.TrackerRepository
import com.example.covid19infos.viewmodel.news.ViewModelFactory

class TrackerViewModelFactory(private val trackerRepository: TrackerRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TrackerViewModel(trackerRepository) as T
    }
}