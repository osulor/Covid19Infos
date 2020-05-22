package com.example.covid19infos.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.covid19infos.R
import com.example.covid19infos.adapter.SymptomsAdapter
import com.example.covid19infos.model.Symptoms
import kotlinx.android.synthetic.main.fragment_symptoms.*

class SymptomsFragment: Fragment(R.layout.fragment_symptoms) {

    val symptom1 = Symptoms(R.drawable.ic_chest_pain_symptoms, "Chest Pain")
    val symptom2 = Symptoms(R.drawable.ic_sore_throat_symptoms, "Sore Throat")
    val symptom3 = Symptoms(R.drawable.ic_muscle_pain_symptoms, "Muscle Pain")
    val symptom4 = Symptoms(R.drawable.ic_fever_symptoms, "Fever")
    val symptom5 = Symptoms(R.drawable.ic_headache_symptoms, "Headache")
    val symptom6 = Symptoms(R.drawable.ic_sneeze_symptoms, "Sneeze")

    private val symptomsArray = listOf(symptom1,symptom2,symptom3,symptom4,symptom5,symptom6)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        symptomsRv.adapter = SymptomsAdapter(symptomsArray)
        symptomsRv.layoutManager = GridLayoutManager(this.requireContext(),2)

        preventionBtn.setOnClickListener {
//            val preventionFragment =
//                PreventionFragment()
//            activity!!.supportFragmentManager.beginTransaction()
//                .replace(R.id.flFragment,preventionFragment)
//                .addToBackStack(preventionFragment.tag)
//                .commit()
            findNavController().navigate(R.id.action_symptomsFragment_to_preventionFragment)

        }
    }

}





