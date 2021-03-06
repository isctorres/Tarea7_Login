package com.example.registro.helper

import androidx.room.TypeConverter
import java.util.*

class DataConverter {
    @TypeConverter
    fun toDate(timestamp: Long?) : Date?{
        return if(timestamp != null ) Date(timestamp) else null
    }

    @TypeConverter
    fun toTimeStamp(date: Date):Long? = date?.time
}