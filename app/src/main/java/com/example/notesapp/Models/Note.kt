package com.example.notesapp.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes_Table")
class Note (
    @PrimaryKey(autoGenerate = true)val id: Int?,
    @ColumnInfo(name = "Title")val title:String?,
    @ColumnInfo(name = "note") val note:String?,
    @ColumnInfo(name = "Date")val date:String?):java.io.Serializable{

}