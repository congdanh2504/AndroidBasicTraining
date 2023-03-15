package com.training.nestedrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool


class ParentItemAdapter(private val itemList: List<ParentItem>) :
    RecyclerView.Adapter<ParentItemAdapter.ParentViewHolder>() {

    private val viewPool = RecycledViewPool()
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ParentViewHolder {
        val view: View =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.parent_item, viewGroup, false)
        return ParentViewHolder(view)
    }

    override fun onBindViewHolder(parentViewHolder: ParentViewHolder, position: Int) {
        val (parentItemTitle, childItemList) = itemList[position]
        parentViewHolder.parentItemTitle.text = parentItemTitle
        val layoutManager = LinearLayoutManager(
            parentViewHolder.childRecyclerView.context,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        layoutManager.initialPrefetchItemCount = childItemList.size
        val childItemAdapter = ChildItemAdapter(childItemList)
        parentViewHolder.childRecyclerView.layoutManager = layoutManager
        parentViewHolder.childRecyclerView.adapter = childItemAdapter
        parentViewHolder.childRecyclerView.setRecycledViewPool(viewPool)
    }

    override fun getItemCount(): Int = itemList.size

    inner class ParentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val parentItemTitle: TextView = itemView.findViewById(R.id.parent_item_title)
        val childRecyclerView: RecyclerView = itemView.findViewById(R.id.child_recyclerview)
    }
}