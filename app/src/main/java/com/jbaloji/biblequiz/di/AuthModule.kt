package com.jbaloji.biblequiz.di

import com.google.firebase.auth.FirebaseAuth
import com.jbaloji.biblequiz.data.repository.AuthRepositoryImpl
import com.jbaloji.biblequiz.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @Provides
    @Singleton
    fun provideAuthRepository(
        auth: FirebaseAuth
    ) : AuthRepository = AuthRepositoryImpl(auth)

}