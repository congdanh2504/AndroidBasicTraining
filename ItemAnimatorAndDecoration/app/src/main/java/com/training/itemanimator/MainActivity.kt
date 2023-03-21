package com.training.itemanimator

import android.os.Bundle
import android.view.animation.AccelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.ItemAnimator
import com.training.itemanimator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val notes: ArrayList<Note> = ArrayList()
        notes.add(Note("Coding", "conding des"))
        notes.add(Note("Do homework", "qweqwezxczx"))
        notes.add(Note("Study", "qweqwe"))
        binding.recycler.layoutManager = LinearLayoutManager(this)
        val adapter = NoteAdapter(notes)
        binding.recycler.adapter = adapter

        val animator: ItemAnimator = DefaultItemAnimator()
        animator.removeDuration = 1000
        binding.recycler.itemAnimator = animator
        binding.recycler.addItemDecoration(MarginItemDecoration(16))

        binding.floatingActionButton.setOnClickListener {
            adapter.addNote(Note("asd", "asdqwe"))
        }
    }
}