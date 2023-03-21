package com.training.recylerviewselection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.selection.Selection
import androidx.recyclerview.selection.SelectionPredicates
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StableIdKeyProvider
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Random

class MainActivity : AppCompatActivity() {
    private val adapter = MainAdapter()
    private var tracker: SelectionTracker<Long>? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        button = findViewById(R.id.button)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        setupAdapter()
        setupTracker()

        button.setOnClickListener {
            setupAdapter()
        }
    }

    private fun setupTracker() {
        tracker = SelectionTracker.Builder<Long>(
            "mySelection",
            recyclerView,
            StableIdKeyProvider(recyclerView),
            MyItemDetailsLookup(recyclerView),
            StorageStrategy.createLongStorage()
        ).withSelectionPredicate(
            SelectionPredicates.createSelectAnything()
        ).build()

        tracker?.addObserver(
            object : SelectionTracker.SelectionObserver<Long>() {
                override fun onSelectionChanged() {
                    super.onSelectionChanged()
                    val nItems: Int? = tracker?.selection!!.size()
                    if (nItems == 2) {
                        launchSum(tracker?.selection!!)
                    }
                }
            })

        adapter.tracker = tracker
    }

    private fun launchSum(selection: Selection<Long>) {
        val list = selection.map {
            adapter.list[it.toInt()]
        }.toList()
        SumActivity.launch(this, list as ArrayList<Int>)
    }

    private fun setupAdapter() {
        adapter.list = createRandomIntList()
        adapter.notifyDataSetChanged()
    }

    private fun createRandomIntList(): List<Int> {
        val random = Random()
        return (1..10).map { random.nextInt() % 100000 }
    }
}