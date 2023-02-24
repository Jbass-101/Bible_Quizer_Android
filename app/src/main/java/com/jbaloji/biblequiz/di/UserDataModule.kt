package com.jbaloji.biblequiz.di

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.jbaloji.biblequiz.data.repository.UserDataRepositoryImpl
import com.jbaloji.biblequiz.domain.repository.UserDataRepository
import com.jbaloji.biblequiz.domain.use_case.userdata.GetUserData
import com.jbaloji.biblequiz.domain.use_case.userdata.UpdateUserData
import com.jbaloji.biblequiz.domain.use_case.userdata.UserDataUseCases
import com.jbaloji.biblequiz.domain.use_case.userdata.WriteUserData
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
        @UsersRef collRef:  CollectionReference
    ) : UserDataRepository = UserDataRepositoryImpl(collRef)

    @Provides
    fun provideUserDataUseCases(
        repo: UserDataRepository
    ) = UserDataUseCases(
        getUserData = GetUserData(repo),
        writeUserData = WriteUserData(repo),
        updateUserData = UpdateUserData(repo)
    )
}