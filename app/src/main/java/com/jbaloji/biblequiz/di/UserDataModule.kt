package com.jbaloji.biblequiz.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.jbaloji.biblequiz.data.repository.UserDataRepositoryImpl
import com.jbaloji.biblequiz.domain.repository.UserDataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier


@Module
@InstallIn(SingletonComponent::class)
object UserDataModule {


    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class UsersRef

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class QuizDocRef

    @UsersRef
    @Provides
    fun providesUsersRef(
        db: FirebaseFirestore
    ) = db.collection("Users")

//    @QuizDocRef
//    @Provides
//    fun providesQuizDocRef(
//        @UsersRef collRef: CollectionReference
//    ) = collRef.document("Quiz")

    @Provides
    fun providesUserDataRepository(
        @UsersRef collRef:  CollectionReference,
        authRef: FirebaseAuth
    ) : UserDataRepository = UserDataRepositoryImpl(collRef,authRef)

}