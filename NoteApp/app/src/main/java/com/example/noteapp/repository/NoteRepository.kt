package com.example.noteapp.repository

import androidx.lifecycle.LiveData
import com.example.noteapp.data.NoteDao
import com.example.noteapp.model.Note
import javax.inject.Inject

class NoteRepository @Inject constructor(private val notesDao: NoteDao) {

    val allNotes: LiveData<List<Note>> = notesDao.getAllNotes()

    suspend fun insert(note: Note) = notesDao.insert(note)

    suspend fun delete(note: Note) = notesDao.delete(note)

    suspend fun update(note: Note) = notesDao.update(note)
}