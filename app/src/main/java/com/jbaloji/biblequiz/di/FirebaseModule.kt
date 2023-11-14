package com.jbaloji.biblequiz.di

import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {

    @Provides
    @Singleton
    fun provideFirebaseFireStore() = FirebaseFirestore.getInstance().apply {
//        useEmulator("10.10.92.92",9091) }

        useEmulator("10.10.92.77",9091) }
//    @Provides
//    @Singleton
//    fun provideFirebaseFireStore() = FirebaseFirestore.getInstance()


    @Provides
    @Singleton
    fun providesFirebaseAuth() = Firebase.auth.apply {
//        useEmulator("10.10.92.92",9090)}

        useEmulator("10.10.92.77",9091) }
//    @Provides
//    @Singleton
//    fun providesFirebaseAuth() = Firebase.auth

//    @Provides
//    @Singleton
//    fun providesFirebaseMessaging() = FirebaseMessaging.getInstance()


}