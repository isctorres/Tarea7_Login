package com.example.registro.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.util.*

@Entity(tableName = User.TABLE_NAME)
data class User(
    @ColumnInfo(name = "name_user") @NotNull var nameUser: String,
    @ColumnInfo(name = "phone_user") var phoneUser: String,
    @ColumnInfo(name = "email_user") @NotNull var emailUser: String? = null,
    @ColumnInfo(name = "pass_user") @NotNull var passUser: String? = null,
    @ColumnInfo(name = "update_at") var updateAt: Date
) {
    companion object {
        const val TABLE_NAME = "tblUser"
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idUser")
    var userId: Int = 0
}