package com.jbaloji.biblequiz.di

import android.util.Log
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.jbaloji.biblequiz.data.repository.QuestionsRepositoryimpl
import com.jbaloji.biblequiz.data.repository.UsersRepositoryImpl
import com.jbaloji.biblequiz.domain.repository.QuestionsRepository
import com.jbaloji.biblequiz.domain.repository.UserRepository
import com.jbaloji.biblequiz.domain.use_case.GetQuestions
import com.jbaloji.biblequiz.domain.use_case.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class QuestionRef

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class UsersRef



    @Provides
    @Singleton
    fun provideFirebaseFirestore() = FirebaseFirestore.getInstance().apply {
        useEmulator("10.0.2.2",8080)
    }


    ////Questions
    @QuestionRef
    @Provides
    fun providesQuestionRef(
        db: FirebaseFirestore
    ) = db.collection("Questions")


    @Provides
    fun providesQuestionRepository(
        @QuestionRef collRef :  CollectionReference
    ) : QuestionsRepository = QuestionsRepositoryimpl(collRef)

    @Provides
    fun provideUseCases(
        repo: QuestionsRepository
    ) = UseCases(
        getQuestions = GetQuestions(repo)
    )

    // ------------Users
    @UsersRef
    @Provides
    fun providesUsersRef(
        db:FirebaseFirestore
    ) = db.collection("Users")


    @Provides
    fun providesUsersRepository(
        @UsersRef   collRef: CollectionReference
    ) : UserRepository = UsersRepositoryImpl(collRef)


}