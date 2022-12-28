package com.welshk.pheme.di

import com.welshk.pheme.networking.ApplicationDataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Module needed for Hilt
 */
@Module
@InstallIn(SingletonComponent::class)
class ApplicationDataRepositoryModule {
    @Provides
    fun provideApplicationDataRepository(): ApplicationDataRepository {
        return ApplicationDataRepository()
    }
}