package com.example.covid19infos.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.example.covid19infos.R
import com.example.covid19infos.util.ApiCallState
import com.example.covid19infos.viewmodel.tracker.TrackerViewModel
import kotlinx.android.synthetic.main.fragment_statistics.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 */
class StatisticsFragment : Fragment() {

    lateinit var trackerViewModel: TrackerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_statistics, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        trackerViewModel = (activity as MainActivity).trackerViewModel

        trackerViewModel.worldStats.observe(viewLifecycleOwner, Observer {responseStatus ->

            when (responseStatus){
                is ApiCallState.Success -> {
                    Log.e("TAG","SUCCESS")

                    responseStatus.data?.let {
                        GlobalScope.launch {
                            recoveredNumber.text = it.TotalRecovered.toString()
                            deadNumber.text = it.TotalDeaths.toString()
                            caseNumber.text = it.TotalConfirmed.toString()
                        }
                    }
                }

                is ApiCallState.Loading -> {
                    Log.e("TAG","LOADING")
                }
            }

        })
    }

}
