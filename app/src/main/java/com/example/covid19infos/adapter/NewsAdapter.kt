package com.example.covid19infos.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.covid19infos.R
import com.example.covid19infos.model.Article
import kotlinx.android.synthetic.main.articles_item.view.*

class NewsAdapter() : RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    val differCallback = object: DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.articles_item,parent,false)
        return ArticleViewHolder(view)
    }

    override fun getItemCount() = differ.currentList.size

    private var onItemClickListener: ((Article) -> Unit)? = null

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val currentArticle = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(currentArticle.urlToImage).into(articleImage)
            tvTitle.text = currentArticle.title
            sourceTv.text = currentArticle.source.name
            tvDescription.text = currentArticle.description
            tvPublishedAt.text = currentArticle.publishedAt

            setOnClickListener {
                onItemClickListener?.let { it(currentArticle) }
            }
        }
    }

    fun setOnItemClickListener(listener: (Article) -> Unit) {
        onItemClickListener = listener
    }

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


}