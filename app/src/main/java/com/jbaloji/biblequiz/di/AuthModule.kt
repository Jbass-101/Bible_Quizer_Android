package com.jbaloji.biblequiz.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.jbaloji.biblequiz.data.repository.AuthRepositoryImpl
import com.jbaloji.biblequiz.domain.repository.AuthRepository
import com.jbaloji.biblequiz.domain.use_case.auth.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AuthModule {


    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class UserUID

    @UserUID
    @Provides
    fun provideCurrentUser(
        auth: FirebaseAuth
    ) = auth.currentUser?.uid


    @Provides
    fun provideAuthRepository(
        auth: FirebaseAuth,
       @UserUID currentUser: String?
    ) : AuthRepository = AuthRepositoryImpl(auth)

    @Provides
    fun provideUseCases(
        repo: AuthRepository
    ) = AuthUseCases(
        currentUser = CurrentUser(repo),
        getCurrentUser = GetCurrentUser(repo),
        logIn = LogIn(repo),
        logOut = LogOut(repo),
        signUp = SignUp(repo),
        loginAnonymously = LoginAnonymously(repo),
        linkWithAnonymous = LinkWithAnonymous(repo)
    )

}