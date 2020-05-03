package com.example.covid19infos

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_symptoms.*

class SymptomsFragment: Fragment(R.layout.fragment_symptoms) {

    lateinit var spannableString : SpannableStringBuilder

    val symptomsArray = listOf("symptom1","symptom2","symptom3","symptom4","symptom5","symptom6")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        spannableString = SpannableStringBuilder("")

        for (string in symptomsArray){
            spannableString.append("- " + string.plus("\n \n"))
        }

        symptomsList.text = spannableString
    }

}