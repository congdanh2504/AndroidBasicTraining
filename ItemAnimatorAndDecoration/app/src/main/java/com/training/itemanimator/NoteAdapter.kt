package com.training.itemanimator

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.training.itemanimator.databinding.NoteBinding

class NoteAdapter(
    private val notes: ArrayList<Note>,
) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: NoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindNote(note: Note, position: Int) {
            binding.title.text = note.title
            binding.des.text = note.des

            binding.delete.setOnClickListener {
                notes.removeAt(position)
                notifyItemRemoved(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = NoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        holder.bindNote(note, position)
    }

    fun addNote(note: Note) {
        notes.add(note)
        notifyItemInserted(notes.size - 1)
    }
}