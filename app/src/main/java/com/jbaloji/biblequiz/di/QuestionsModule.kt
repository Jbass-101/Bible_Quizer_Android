package com.jbaloji.biblequiz.di

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.jbaloji.biblequiz.data.repository.QuestionsRepositoryImpl
import com.jbaloji.biblequiz.domain.repository.QuestionsRepository
import com.jbaloji.biblequiz.domain.use_case.questions.GetQuestions
import com.jbaloji.biblequiz.domain.use_case.questions.GetQuestionsLevel
import com.jbaloji.biblequiz.domain.use_case.questions.QuestionsUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
object QuestionsModule {

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class QuestionRef

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class QuestionDocRef


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
    ) : QuestionsRepository = QuestionsRepositoryImpl(collRef,docRef)

    @Provides
    fun provideUseCases(
        repo: QuestionsRepository
    ) = QuestionsUseCases(
        getQuestions = GetQuestions(repo),
        getQuestionLevel = GetQuestionsLevel(repo)
    )












}