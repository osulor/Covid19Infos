package com.example.covid19infos.ui

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.View
import androidx.fragment.app.Fragment
import com.example.covid19infos.R
import kotlinx.android.synthetic.main.fragment_symptoms.*

class SymptomsFragment: Fragment(R.layout.fragment_symptoms) {

    lateinit var spannableString : SpannableStringBuilder

    val symptomsArray = listOf("Cough\n","Shortness of breath or difficulty breathing\n",
        "Fever\n","Chills\n","Repeated shaking with chills\n","Muscle pain")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        spannableString = SpannableStringBuilder("")

        for (string in symptomsArray){
            spannableString.append("- ".plus(string + "\n"))
        }

        symptomsList.text = spannableString

        preventionBtn.setOnClickListener {
            val preventionFragment =
                PreventionFragment()
            activity!!.supportFragmentManager.beginTransaction()
                .replace(R.id.flFragment,preventionFragment)
                .addToBackStack(preventionFragment.tag)
                .commit()

        }
    }

}





