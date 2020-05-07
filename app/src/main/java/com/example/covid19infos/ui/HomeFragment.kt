package com.example.covid19infos.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.covid19infos.R
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        spreadBtn.setOnClickListener {
            val spreadInfosFragment =
                SpreadInfosFragment()
            activity!!.supportFragmentManager.beginTransaction()
                .replace(R.id.flFragment,spreadInfosFragment)
                .addToBackStack(spreadInfosFragment.tag)
                .commit()
        }
    }

}
