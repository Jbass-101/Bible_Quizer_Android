package com.jbaloji.biblequiz.di

import android.app.Application
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jbaloji.biblequiz.core.Constants.BASE_URL
import com.jbaloji.biblequiz.domain.repository.ApiRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    fun provideHttpCache(application: Application): Cache {
        val cacheSize = 10 * 1024 * 1024
        return Cache(application.cacheDir, cacheSize.toLong())
    }

    @Provides
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
        gsonBuilder.setPrettyPrinting()
        return gsonBuilder.create()
    }

    @Provides
    fun provideOkhttpClient(cache: Cache?): OkHttpClient {
        val client = OkHttpClient.Builder()
        client.cache(cache)
        return client.build()
    }

    @Provides
    fun provideRetrofit(gson: Gson?, okHttpClient: OkHttpClient?): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun providesApiService(retrofit: Retrofit): ApiRepository {
        return retrofit.create(ApiRepository::class.java)
    }
}