package com.example.registro.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDAO {

    @Query("select * from tblUser order by name_user")
    fun loadAllUser() : List<User>

    @Insert
    fun insertUser(user: User)
}