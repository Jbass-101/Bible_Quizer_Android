package com.jbaloji.biblequiz.room.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.jbaloji.biblequiz.room.dao.LocalUserDao
import com.jbaloji.biblequiz.room.entities.LocalUser


@Database(entities = [LocalUser::class],
    version = 2,
    autoMigrations = [
    ],
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun localUserDao() : LocalUserDao
}