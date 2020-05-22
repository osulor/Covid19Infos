package com.example.covid19infos.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covid19infos.R
import com.example.covid19infos.adapter.NewsAdapter
import com.example.covid19infos.model.Article
import com.example.covid19infos.util.ApiCallState
import com.example.covid19infos.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.fragment_articles.*

class NewsFragment: Fragment(R.layout.fragment_articles) {

    lateinit var newsViewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsViewModel = (activity as MainActivity).newsViewModel
        setRV()

        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("article",it)
            }
            findNavController().navigate(R.id.action_newsFragment_to_articleFragment,bundle)
        }

        newsViewModel.coronaNews.observe(viewLifecycleOwner, Observer {response ->

            when(response){
                is ApiCallState.Success -> {
                    //hideProgressBar
                    Log.e("TAG","Success")
                    response.data?.let { newsResponse ->
                        newsAdapter.differ.submitList(newsResponse.articles)
                    }
                }

                is ApiCallState.Error -> {
                    //hideProgress bar
                    response.message?.let { message ->
                        Log.e("TAG","an error has occured: $message")
                    }
                }

                is ApiCallState.Loading -> {
                    //showProgressbar
                    Log.e("TAG","LOADING")
                }
            }

        })


    }

    private fun setRV(){
        newsAdapter = NewsAdapter()
       // val itemDecoration = DividerItemDecoration(this.requireContext(), DividerItemDecoration.VERTICAL)

        articlesRV.apply {
            adapter = newsAdapter
            layoutManager  = LinearLayoutManager(activity)
        }

        //articlesRV.addItemDecoration(itemDecoration)

    }
}


