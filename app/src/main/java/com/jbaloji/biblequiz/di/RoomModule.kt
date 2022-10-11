package com.jbaloji.biblequiz.di

import android.content.Context
import androidx.room.Room
import com.jbaloji.biblequiz.data.repository.LocalUserRepositoryImpl
import com.jbaloji.biblequiz.room.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import hilt_aggregated_deps._dagger_hilt_android_internal_modules_ApplicationContextModule

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    fun provideRoomDatabase(
        @ApplicationContext appContext: Context
    ) =Room.databaseBuilder(appContext,AppDa::class.java,
        "user"
    )

    @Provides
    fun provideUserDao(
        appDatabase: AppDatabase
    ) = appDatabase.localUserDao()

    @Provides
    fun provideLocalUserRepo (
        appDatabase: AppDatabase
    ) = LocalUserRepositoryImpl(appDatabase.localUserDao())

}