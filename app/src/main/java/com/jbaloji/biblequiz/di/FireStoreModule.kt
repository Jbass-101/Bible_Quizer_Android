package com.jbaloji.biblequiz.di

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.jbaloji.biblequiz.data.repository.QuestionsRepositoryimpl
import com.jbaloji.biblequiz.domain.repository.QuestionsRepository
import com.jbaloji.biblequiz.domain.use_case.questions.GetQuestions
import com.jbaloji.biblequiz.domain.use_case.questions.GetQuestionsLevel
import com.jbaloji.biblequiz.domain.use_case.questions.QuestionsUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FireStoreModule {

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class QuestionRef

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class QuestionDocRef

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class UsersRef



    @Provides
    @Singleton
    fun provideFirebaseFireStore() = FirebaseFirestore.getInstance().apply {
        useEmulator("10.0.2.2",8080)
    }

//    @Provides
//    @Singleton
//    fun provideFirebaseFireStore() = FirebaseFirestore.getInstance()


    ////Questions
    @QuestionRef
    @Provides
    fun providesQuestionRef(
        db: FirebaseFirestore
    ) = db.collection("Questions").document("Levels").collection("Level_1")

    @QuestionDocRef
    @Provides
    fun providesQuestionDocRef(
        db: FirebaseFirestore
    ) = db.collection("Questions").document("Levels")


    @Provides
    fun providesQuestionRepository(
        @QuestionRef collRef :  CollectionReference,
        @QuestionDocRef docRef: DocumentReference
    ) : QuestionsRepository = QuestionsRepositoryimpl(collRef,docRef)

    @Provides
    fun provideUseCases(
        repo: QuestionsRepository
    ) = QuestionsUseCases(
        getQuestions = GetQuestions(repo),
        getQuestionLevel = GetQuestionsLevel(repo)
    )











}