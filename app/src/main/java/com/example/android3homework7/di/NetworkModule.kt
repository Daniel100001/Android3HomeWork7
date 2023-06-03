package com.example.android3homework7.di

import com.example.android3homework7.data.remote.RetrofitClient
import com.example.android3homework7.data.remote.apiservises.PokemonApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    val retrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun provideCharacterApiService() : PokemonApiService {
        return retrofitClient.providePokemonApiService()
    }
}