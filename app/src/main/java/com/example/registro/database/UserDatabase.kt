package com.example.registro.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.registro.helper.DataConverter

@Database(entities = arrayOf(User::class), version = 1, exportSchema = false)
@TypeConverters(DataConverter::class)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao() : UserDAO
    companion object{
        private const val DATABASE_NAME = "users_database.db"
        @Volatile
        private var INSTANCE : UserDatabase? = null

        fun getInstance(context: Context) : UserDatabase?{
            INSTANCE ?: synchronized(this){
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    DATABASE_NAME
                ).build()
            }
            return INSTANCE
        }
    }
}