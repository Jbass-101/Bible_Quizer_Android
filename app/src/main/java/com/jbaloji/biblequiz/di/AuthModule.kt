package com.jbaloji.biblequiz.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.jbaloji.biblequiz.data.repository.AuthRepositoryImpl
import com.jbaloji.biblequiz.domain.repository.AuthRepository
import com.jbaloji.biblequiz.domain.use_case.auth.*
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
    fun providesFirebaseAuth() = Firebase.auth

    @Provides
    fun provideAuthRepository(
        auth: FirebaseAuth
    ) : AuthRepository = AuthRepositoryImpl(auth)

    @Provides
    fun provideUseCases(
        repo: AuthRepository
    ) = AuthUseCases(
        currentUser = CurrentUser(repo),
        logIn = LogIn(repo),
        logOut = LogOut(repo),
        signUp = SignUp(repo)
    )

}