package com.training.nestedrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ChildItemAdapter(private val childItemList: List<ChildItem>) :
    RecyclerView.Adapter<ChildItemAdapter.ChildViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ChildViewHolder {
        val view: View =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.child_item, viewGroup, false)
        return ChildViewHolder(view)
    }

    override fun onBindViewHolder(childViewHolder: ChildViewHolder, position: Int) {
        val childItemTitle = childItemList[position].childItemTitle
        childViewHolder.childItemTitle.text = childItemTitle
    }

    override fun getItemCount(): Int = childItemList.size

    inner class ChildViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val childItemTitle: TextView = itemView.findViewById(R.id.child_item_title)
    }
}