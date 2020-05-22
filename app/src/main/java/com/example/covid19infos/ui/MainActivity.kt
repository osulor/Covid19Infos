package com.example.covid19infos.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.covid19infos.R
import com.example.covid19infos.repository.NewsRepository
import com.example.covid19infos.viewmodel.NewsViewModel
import com.example.covid19infos.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var newsViewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModelFactory = ViewModelFactory(NewsRepository())
        newsViewModel = ViewModelProvider(this, viewModelFactory).get(NewsViewModel::class.java)
        bottom_nav.setupWithNavController(navHostFragment.findNavController())
    }

    fun switchToSpreadFragment(){
        val spreadInfosFragment =
            SpreadInfosFragment()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.flFragment,spreadInfosFragment)
            .addToBackStack(spreadInfosFragment.tag)
            .commit()
    }
}
