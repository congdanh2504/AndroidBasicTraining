package com.example.noteapp.model

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "notesTable")
@Parcelize
data class Note(
    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "description")
    var description: String,
    @ColumnInfo(name = "isDone")
    var isDone: Boolean
) : Parcelable {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}