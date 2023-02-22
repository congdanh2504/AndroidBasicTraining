package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CardAdapter(private val list: List<CardItem>): RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    class CardViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val examName: TextView = view.findViewById(R.id.examName)
        val examDate: TextView = view.findViewById(R.id.examDate)
        val examMessage: TextView = view.findViewById(R.id.examMessage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.exam_card, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = list[position]
        holder.examName.text = card.name
        holder.examDate.text = card.date
        holder.examMessage.text = card.message
    }

    override fun getItemCount(): Int = list.size

}

