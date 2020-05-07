package com.example.covid19infos.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.covid19infos.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val symptomsFragment = SymptomsFragment()
        val homeFragment = HomeFragment()
        val articlesFragment = ArticlesFragment()
        showCurrentFragment(homeFragment)

        bottom_nav.setOnNavigationItemSelectedListener {menuItem ->
            when(menuItem.itemId){
                R.id.miSymptoms -> showCurrentFragment(symptomsFragment)
                R.id.miHome -> showCurrentFragment(homeFragment)
                R.id.miArticles -> showCurrentFragment(articlesFragment)
            }
            true
        }
    }

    private fun showCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.flFragment,fragment)
            .addToBackStack(fragment.tag)
            .commit()
    }

//    private fun showBulletPoint(text: String){
//        val bulletSpan= BulletSpan(30, Color.DKGRAY)
//
//        spannableString.setSpan(bulletSpan,spannableString.indexOf(text),spannableString.indexOf(text) + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
//
//    }

}
