package com.example.noteapp.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.R
import com.example.noteapp.databinding.NoteBinding
import com.example.noteapp.model.Note

class NoteAdapter2(
    private val onDelete: (Note) -> Unit,
    private val onUpdate: (Note) -> Unit,
    private val onEdit: (Note) -> Unit
): ListAdapter<Note, NoteAdapter2.ViewHolder>(NoteDiffCallback()) {

    class NoteDiffCallback : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }
    }

    inner class ViewHolder(private val binding: NoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindNote(note: Note) {
            binding.title.text = note.title
            binding.des.text = note.description

            binding.delete.setOnClickListener {
                onDelete(note)
            }
            binding.edit.setOnClickListener {
                onEdit(note)
            }
            binding.checkBox.setOnClickListener {
                note.isDone = !note.isDone
                onUpdate(note)
            }

            binding.checkBox.isChecked = note.isDone
            binding.layout.setBackgroundResource(if (note.isDone) R.color.mark_item else R.color.item)
            binding.title.paintFlags =
                if (note.isDone) Paint.STRIKE_THRU_TEXT_FLAG else binding.title.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
            binding.des.paintFlags =
                if (note.isDone) Paint.STRIKE_THRU_TEXT_FLAG else binding.title.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = NoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = getItem(position)
        holder.bindNote(note)
    }

}