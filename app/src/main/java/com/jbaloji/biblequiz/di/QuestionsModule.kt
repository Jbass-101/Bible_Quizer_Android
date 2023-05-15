package com.jbaloji.biblequiz.di

import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.jbaloji.biblequiz.core.Constants.ALL_LEVELS_DOC
import com.jbaloji.biblequiz.core.Constants.ROOT_COLLECTION
import com.jbaloji.biblequiz.data.repository.QuestionsRepositoryImpl
import com.jbaloji.biblequiz.domain.repository.QuestionsRepository
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
    annotation class QuestionDocRef

    @QuestionDocRef
    @Provides
    fun providesQuestionDocRef(
        db: FirebaseFirestore
    ) = db.collection(ROOT_COLLECTION).document(ALL_LEVELS_DOC)


    @Provides
    fun providesQuestionRepository(
        @QuestionDocRef docRef: DocumentReference
    ) : QuestionsRepository = QuestionsRepositoryImpl(docRef)













}