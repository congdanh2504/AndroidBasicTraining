package com.training.nestedrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val parentRecyclerViewItem = findViewById<RecyclerView>(R.id.parent_recyclerview)
        val layoutManager = LinearLayoutManager(this)
        val parentItemAdapter = ParentItemAdapter(
            parentItemList()
        )
        parentRecyclerViewItem.adapter = parentItemAdapter
        parentRecyclerViewItem.layoutManager = layoutManager
    }

    private fun parentItemList(): List<ParentItem> {
        val itemList: MutableList<ParentItem> = ArrayList()
        val item = ParentItem(
            "Title 1",
            childItemList()
        )
        itemList.add(item)
        val item1 = ParentItem(
            "Title 2",
            childItemList()
        )
        itemList.add(item1)
        val item2 = ParentItem(
            "Title 3",
            childItemList()
        )
        itemList.add(item2)
        val item3 = ParentItem(
            "Title 4",
            childItemList()
        )
        itemList.add(item3)
        return itemList
    }

    private fun childItemList(): List<ChildItem> {
        val childItemList: MutableList<ChildItem> = ArrayList()
        childItemList.add(ChildItem("Card 1"))
        childItemList.add(ChildItem("Card 2"))
        childItemList.add(ChildItem("Card 3"))
        childItemList.add(ChildItem("Card 4"))
        return childItemList
    }
}