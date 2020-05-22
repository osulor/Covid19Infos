package com.example.covid19infos.ui

import android.os.Bundle
import android.text.SpannableStringBuilder
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.covid19infos.R
import com.example.covid19infos.adapter.PreventionAdapter
import kotlinx.android.synthetic.main.fragment_prevention.*

/**
 * A simple [Fragment] subclass.
 */
class PreventionFragment : Fragment(R.layout.fragment_prevention) {

    val preventionArray = listOf(R.drawable.ic_home_prevention,R.drawable.ic_touching_prevention ,R.drawable.ic_wash_prevention,
        R.drawable.ic_cough_prevention,R.drawable.ic_disinfect_prevention,R.drawable.ic_contact_prevention)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        preventionRV.adapter = PreventionAdapter(preventionArray)
        preventionRV.layoutManager = GridLayoutManager(this.requireContext(),2)

    }

}
