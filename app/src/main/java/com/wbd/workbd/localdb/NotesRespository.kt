package com.wbd.workbd.localdb


import androidx.lifecycle.LiveData
import androidx.room.RoomDatabase

class NotesRespository (var dataBase: NotesDb){
    var notes: LiveData<List<Notes>> = dataBase.noteDao().getAll()
    fun getAll(): LiveData<List<Notes>>{
        return notes
    }
    suspend fun insert(notes: Notes){
        dataBase.noteDao().insert(notes)
    }
    suspend fun delete(notes: Notes){
        dataBase.noteDao().delete(notes)
    }
    
}