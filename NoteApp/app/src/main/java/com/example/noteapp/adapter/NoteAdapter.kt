package com.example.noteapp.adapter

import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.R
import com.example.noteapp.databinding.NoteBinding
import com.example.noteapp.model.Note

class NoteAdapter(
    private val notes: ArrayList<Note>,
    private val onDelete: (Note) -> Unit,
    private val onUpdate: (Note) -> Unit,
    private val onEdit: (Note) -> Unit
) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

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

    class NoteCallback(private val oldList: List<Note>, private val newList: List<Note>) :
        DiffUtil.Callback() {

        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] === newList[newItemPosition]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = NoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        holder.bindNote(note)
    }

    fun setNote(newList: List<Note>) {
        val diffCallback = NoteCallback(notes, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        notes.clear()
        notes.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }
}