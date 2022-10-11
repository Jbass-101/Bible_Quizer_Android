package com.jbaloji.biblequiz.data.repository


import com.jbaloji.biblequiz.room.dao.LocalUserDao
import com.jbaloji.biblequiz.room.entities.LocalUser
import javax.inject.Inject

class LocalUserRepositoryImpl @Inject constructor(
    private val localUserDao: LocalUserDao
) {
     suspend fun getLocalUser() = localUserDao.getLocalUser()

     suspend fun insertUser(user: LocalUser) = localUserDao.insertAll(user)

}