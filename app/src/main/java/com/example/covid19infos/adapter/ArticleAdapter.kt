package com.example.covid19infos.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19infos.R
import com.example.covid19infos.model.Article

class ArticleAdapter(val articleList: List<Article>) : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.articles_item,parent,false)
        return ArticleViewHolder(view)
    }

    override fun getItemCount() = articleList.size


    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val currentArticle = articleList[position]
        holder.apply {
            title.text = currentArticle.title
            source.text = currentArticle.source.name
            description.text = currentArticle.description
            publishedAt.text = currentArticle.publishedAt
        }
    }

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val title = itemView.findViewById<TextView>(R.id.tvTitle)
        val source = itemView.findViewById<TextView>(R.id.sourceTv)
        val description = itemView.findViewById<TextView>(R.id.tvDescription)
        val publishedAt = itemView.findViewById<TextView>(R.id.tvPublishedAt)
    }
}