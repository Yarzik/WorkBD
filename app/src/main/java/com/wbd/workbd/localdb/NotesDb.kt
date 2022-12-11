package com.wbd.workbd.localdb

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Notes::class], version = 1, exportSchema = true)
abstract class NotesDb : RoomDatabase(){
    abstract fun noteDao(): NotesDao
}