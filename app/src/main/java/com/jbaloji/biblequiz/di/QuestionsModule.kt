package com.jbaloji.biblequiz.di

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.jbaloji.biblequiz.core.Constants.ALL_LEVELS_DOC
import com.jbaloji.biblequiz.core.Constants.LEVEL_COLLECTION
import com.jbaloji.biblequiz.core.Constants.ROOT_COLLECTION
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
    ) = db.collection(ROOT_COLLECTION).document(ALL_LEVELS_DOC).collection(LEVEL_COLLECTION)

    @QuestionDocRef
    @Provides
    fun providesQuestionDocRef(
        db: FirebaseFirestore
    ) = db.collection(ROOT_COLLECTION).document(ALL_LEVELS_DOC)


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