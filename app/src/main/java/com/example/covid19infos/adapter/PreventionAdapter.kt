package com.example.covid19infos.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19infos.R
import kotlinx.android.synthetic.main.prevention_item.view.*

class PreventionAdapter(val preventionList : List<Int>) : RecyclerView.Adapter<PreventionAdapter.preventionViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): preventionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.prevention_item,parent,false)
        return preventionViewHolder(view)
    }

    override fun getItemCount(): Int {
       return preventionList.size
    }

    override fun onBindViewHolder(holder: preventionViewHolder, position: Int) {
        val currentItem = preventionList[position]
        holder.itemView.itemImage.setImageResource(currentItem)
    }


    inner class preventionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


}