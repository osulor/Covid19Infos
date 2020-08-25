package com.example.covid19infos.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.covid19infos.R
import com.example.covid19infos.util.ApiCallState
import com.example.covid19infos.viewmodel.tracker.TrackerViewModel
import kotlinx.android.synthetic.main.fragment_statistics.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class StatisticsFragment : Fragment() {

    lateinit var trackerViewModel: TrackerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_statistics, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        trackerViewModel = (activity as MainActivity).trackerViewModel
        getWorldStats()

        searchButton.setOnClickListener {
            val country = searchView.text.toString().toUpperCase()
            statText.text = "Current Covid-19 Statistic in $country"
            getCountryStats(country)
        }

    }

    private fun getWorldStats(){
        trackerViewModel.worldStats.observe(viewLifecycleOwner, Observer {responseStatus ->

            when (responseStatus){
                is ApiCallState.Success -> {
                    Log.e("TAG","SUCCESS")
                    responseStatus.data?.let {
                        GlobalScope.launch {
                            recoveredNumber.text = convertData(it.TotalRecovered)
                            deadNumber.text = convertData(it.TotalDeaths)
                            caseNumber.text = convertData(it.TotalConfirmed)
                        }
                    }
                }
                is ApiCallState.Loading -> {
                    Log.e("TAG","LOADING")
                }
            }
        })
    }

    private fun getCountryStats(country: String){
        trackerViewModel.getCountryStats(country)
        trackerViewModel.countryStats.observe(viewLifecycleOwner, Observer {responseStatus ->

            when (responseStatus){
                is ApiCallState.Success -> {
                    Log.e("TAG","SUCCESS")
                    responseStatus.data?.let {
                        GlobalScope.launch {
                            val countryData = it[it.size - 1]
                            recoveredNumber.text = convertData(countryData.Recovered)
                            deadNumber.text = convertData(countryData.Deaths)
                            caseNumber.text = convertData(countryData.Confirmed)
                        }
                    }
                }
                is ApiCallState.Loading -> {
                    Log.e("TAG","LOADING")
                }
            }
        })
    }

    private fun convertData(number: Int) : String {

        var finalData = number.toString()

        if (number.toString().length in 4..6){
            val digit = number / 1000
            val remainder = number % 1000
            if (remainder == 0) {
                finalData = digit.toString().plus("K")
            } else {
                finalData = digit.toString() + "." + remainder.toString()[0] + "K"
            }
        }

        if (number.toString().length >= 7){
            val digit = number / 1000000
            val remainder = number % 1000000
            if (remainder == 0) {
                finalData = digit.toString().plus("M")
            } else {
                finalData = digit.toString() + "." + remainder.toString()[0] + "M"
            }
        }

        return finalData
    }

}
