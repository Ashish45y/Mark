package com.example.notesapp.Database

import androidx.lifecycle.LiveData
import com.example.notesapp.Models.Note

class NoteRepository(private val noteDao: NoteDao) {
    val allnote:LiveData<List<Note>> = noteDao.getallNote()
    suspend fun insert(note: Note){
        noteDao.insert(note)
    }
    suspend fun delete(note: Note){
        noteDao.Delete(note)
    }
    suspend fun update(note: Note){
        noteDao.update(note.id,note.title,note.note)
    }
}