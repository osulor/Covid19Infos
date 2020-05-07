package com.example.covid19infos.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covid19infos.R
import com.example.covid19infos.adapter.ArticleAdapter
import com.example.covid19infos.model.Article
import com.example.covid19infos.model.Source
import kotlinx.android.synthetic.main.fragment_articles.*

class ArticlesFragment: Fragment(R.layout.fragment_articles) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val articleList = mutableListOf<Article>()
        val source = Source("1","SourceName")
        val article1 = Article("AuthorName","hldkldjfjd","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore \n" +
                " et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut\n" +
                " aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum \n" +
                " dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia\n" +
                " deserunt mollit anim id est laborum.","May 5, 2020",source,"Title",
        "sdhkdjksjjkd","jkdljkdjlkdjkjd")

        articleList.add(article1)
        articleList.add(article1)
        articleList.add(article1)
        articleList.add(article1)
        articleList.add(article1)
        articleList.add(article1)

        setRV(articleList)
    }

    private fun setRV(articleList: List<Article>){
        articlesRV.adapter = ArticleAdapter(articleList)
        articlesRV.layoutManager = LinearLayoutManager(this.requireContext())
        val itemDecoration = DividerItemDecoration(this.requireContext(), DividerItemDecoration.VERTICAL)
        //articlesRV.addItemDecoration(itemDecoration)

    }
}


