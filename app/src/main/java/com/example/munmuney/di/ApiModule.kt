package com.example.munmuney.di

import com.example.munmuney.api.AffirmationApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ServiceComponent
import retrofit2.Retrofit

/**
 * Created by natasha.santoso on 16/10/20.
 */
@Module
@InstallIn(ServiceComponent::class)
class ApiModule {
  @Provides
  fun provideAffirmationApi(retrofit: Retrofit) {
    retrofit.create(AffirmationApi::class.java)
  }
}