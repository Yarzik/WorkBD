package com.wbd.workbd.localdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.wbd.workbd.localdb.Notes

@Dao
interface NotesDao {
    @Query("Select * from Notes")
    fun getAll(): LiveData<List<Notes>>
    @Insert(onConflict = REPLACE)
    suspend fun insert(notes: Notes)
    @Delete
    suspend fun delete(notes: Notes)
    }