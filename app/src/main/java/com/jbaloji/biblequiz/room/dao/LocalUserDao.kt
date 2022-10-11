package com.jbaloji.biblequiz.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jbaloji.biblequiz.room.entities.LocalUser


@Dao
interface LocalUserDao {
    @Query("SELECT * FROM localuser LIMIT 1" )
    suspend fun getLocalUser(): LocalUser

    @Insert
    suspend fun insertAll(vararg : LocalUser)

}