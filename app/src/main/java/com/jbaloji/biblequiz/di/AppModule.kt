package com.jbaloji.biblequiz.di

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.jbaloji.biblequiz.data.repository.QuestionsRepositoryimpl
import com.jbaloji.biblequiz.domain.repository.QuestionsRepository
import com.jbaloji.biblequiz.domain.use_case.GetQuestions
import com.jbaloji.biblequiz.domain.use_case.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
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

//    @Provides
//    @Singleton
//    fun provideFirebaseFirestore() = FirebaseFirestore.getInstance()


    ////Questions
    @QuestionRef
    @Provides
    fun providesQuestionRef(
        db: FirebaseFirestore
    ) = db.collection("Questions").document("Levels").collection("Level_1")


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










}