package com.jbaloji.biblequiz.di

import android.util.Log
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.jbaloji.biblequiz.data.repository.QuestionsRepositoryimpl
import com.jbaloji.biblequiz.domain.repository.QuestionsRepository
import com.jbaloji.biblequiz.domain.use_case.GetQuestions
import com.jbaloji.biblequiz.domain.use_case.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun providesFirebaseFirestore() = FirebaseFirestore.getInstance().apply {
        try {
            useEmulator("localhost",8080)
        }catch (e: java.lang.IllegalStateException){
            Log.e("App Module","Emulator not ready", e)
        }
        firestoreSettings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(false).build()
    }

    @Provides
    fun providesQuestionRef(
        db: FirebaseFirestore
    ) = db.collection("Questions")

    @Provides
    fun providesQuestionRepository(
        questionRef : CollectionReference
    ) : QuestionsRepository = QuestionsRepositoryimpl(questionRef)

    @Provides
    fun provideUseCases(
        repo: QuestionsRepository
    ) = UseCases(
        getQuestions = GetQuestions(repo)
    )
}