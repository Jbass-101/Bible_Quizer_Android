package com.jbaloji.biblequiz.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.jbaloji.biblequiz.core.FirestoreModuleConstants.Foundation
import com.jbaloji.biblequiz.core.FirestoreModuleConstants.Levels
import com.jbaloji.biblequiz.core.FirestoreModuleConstants.Questions
import com.jbaloji.biblequiz.core.FirestoreModuleConstants.Users
import com.jbaloji.biblequiz.data.repository.LessonRepositoryImpl
import com.jbaloji.biblequiz.data.repository.QuestionsRepositoryImpl
import com.jbaloji.biblequiz.data.repository.UserDataRepositoryImpl
import com.jbaloji.biblequiz.domain.repository.LessonsRepository
import com.jbaloji.biblequiz.domain.repository.QuestionsRepository
import com.jbaloji.biblequiz.domain.repository.UserDataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
object FirestoreModule {

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class QuestionDocRef

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class UsersRef

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class LessonRef

    @QuestionDocRef
    @Provides
    fun providesQuestionDocRef(
        db: FirebaseFirestore
    ) = db.collection(Questions).document(Levels)

    @UsersRef
    @Provides
    fun providesUsersRef(
        db: FirebaseFirestore
    ) = db.collection(Users)

    @LessonRef
    @Provides
    fun providesLessonRef(
        db: FirebaseFirestore
    ) = db.collection(Foundation)

    @Provides
    fun providesQuestionRepository(
        @QuestionDocRef docRef: DocumentReference
    ) : QuestionsRepository = QuestionsRepositoryImpl(docRef)

    @Provides
    fun providesUserDataRepository(
        @UsersRef collRef: CollectionReference,
        authRef: FirebaseAuth
    ) : UserDataRepository = UserDataRepositoryImpl(collRef,authRef)

    @Provides
    fun providesLessonRepository(
        @LessonRef docRef: DocumentReference
    ) : LessonsRepository = LessonRepositoryImpl(docRef)
}