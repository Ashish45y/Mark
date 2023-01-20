package com.example.notesapp.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.notesapp.Models.Note

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Delete
    suspend fun Delete(note: Note)

    @Query("Select * from notes_table order by ID ASC")
    fun getallNote() :LiveData<List<Note>>

    @Query("UPDATE Notes_Table Set title= :title, note=:note WHERE id=:id")
    suspend fun update(id:Int?,title:String?,note:String?)


}