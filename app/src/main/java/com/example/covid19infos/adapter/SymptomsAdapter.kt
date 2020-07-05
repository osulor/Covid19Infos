package com.example.covid19infos.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19infos.R
import com.example.covid19infos.model.news.Symptoms
import kotlinx.android.synthetic.main.symptoms_item.view.*

class SymptomsAdapter(val symptomsList : List<Symptoms>) : RecyclerView.Adapter<SymptomsAdapter.SymptomsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SymptomsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.symptoms_item,parent,false)
        return SymptomsViewHolder(view)
    }

    override fun getItemCount(): Int {
       return symptomsList.size
    }

    override fun onBindViewHolder(holder: SymptomsViewHolder, position: Int) {
        val currentItem = symptomsList[position]
        holder.itemView.symptomImage.setImageResource(currentItem.imageID)
        holder.itemView.symptomDesc.text = currentItem.description
    }

    inner class SymptomsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}