package com.wbd.workbd.localdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Notes(var title: String, var Body: String){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
