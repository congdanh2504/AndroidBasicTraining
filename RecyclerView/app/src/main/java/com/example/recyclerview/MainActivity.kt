package com.example.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CardAdapter(getData())
    }

    private fun getData(): List<CardItem> {
        val list: MutableList<CardItem> = ArrayList()
        list.add(CardItem( "First Exam","May 23, 2015","Best Of Luck"))
        list.add(CardItem( "Second Exam","June 09, 2015","b of l"))
        list.add(CardItem( "My Test Exam","April 27, 2017","This is testing exam .."))
        return list
    }
}
