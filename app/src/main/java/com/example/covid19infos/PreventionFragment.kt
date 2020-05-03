package com.example.covid19infos

import android.os.Bundle
import android.text.SpannableStringBuilder
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_prevention.*

/**
 * A simple [Fragment] subclass.
 */
class PreventionFragment : Fragment(R.layout.fragment_prevention) {

    lateinit var spannableString : SpannableStringBuilder

    val symptomsArray = listOf("prevention1","prevention2","prevention3","prevention4")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        spannableString = SpannableStringBuilder("")

        for (string in symptomsArray){
            spannableString.append("- " + string.plus("\n \n"))
        }

        preventionList.text = spannableString
    }
}
