package com.example.noteapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.model.Note
import com.example.noteapp.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) : ViewModel() {
    val allNotes: LiveData<List<Note>> = noteRepository.allNotes

    fun deleteNote(note: Note) = viewModelScope.launch {
        noteRepository.delete(note)
    }

    fun updateNote(note: Note) = viewModelScope.launch {
        noteRepository.update(note)
    }

    fun addNote(note: Note) = viewModelScope.launch {
        noteRepository.insert(note)
    }

}