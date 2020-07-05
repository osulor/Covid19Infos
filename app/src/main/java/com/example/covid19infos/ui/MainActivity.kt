package com.example.covid19infos.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.covid19infos.R
import com.example.covid19infos.repository.NewsRepository
import com.example.covid19infos.repository.TrackerRepository
import com.example.covid19infos.viewmodel.news.NewsViewModel
import com.example.covid19infos.viewmodel.news.ViewModelFactory
import com.example.covid19infos.viewmodel.tracker.TrackerViewModel
import com.example.covid19infos.viewmodel.tracker.TrackerViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var newsViewModel: NewsViewModel
    lateinit var trackerViewModel: TrackerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModelFactory =
            ViewModelFactory(
                NewsRepository()
            )

        val trackerViewModelFactory = TrackerViewModelFactory(TrackerRepository())

        newsViewModel = ViewModelProvider(this, viewModelFactory).get(NewsViewModel::class.java)
        trackerViewModel = ViewModelProvider(this,trackerViewModelFactory).get(TrackerViewModel::class.java)

        bottom_nav.setupWithNavController(navHostFragment.findNavController())
    }

}
