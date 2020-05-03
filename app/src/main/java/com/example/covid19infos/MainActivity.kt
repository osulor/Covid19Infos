package com.example.covid19infos

import android.content.res.Resources
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.BulletSpan
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_symptoms.*

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
