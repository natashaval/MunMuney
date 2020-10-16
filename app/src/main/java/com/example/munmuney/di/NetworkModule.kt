package com.example.munmuney.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by natasha.santoso on 16/10/20.
 */
@Module
@InstallIn(ApplicationComponent::class)
class NetworkModule {
  @Provides
  @Singleton
  fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
    return Retrofit.Builder().baseUrl(AFFIRMATION_BASE_URL).client(okHttpClient).addConverterFactory(
        GsonConverterFactory.create(gson)).build()
  }

  @Provides
  @Singleton
  fun provideOkHttpClient(logger: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient.Builder().addInterceptor(logger).build()
  }

  @Provides
  @Singleton
  fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
  }

  @Provides
  fun provideGson(): Gson {
    return GsonBuilder().create()
  }

  companion object {
    private const val AFFIRMATION_BASE_URL = "https://www.affirmations.dev"
  }
}