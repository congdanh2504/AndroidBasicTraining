package com.training.cleanarchitecture.di

import com.training.cleanarchitecture.data.repository.UserRepositoryImpl
import com.training.cleanarchitecture.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideUserRepository(): UserRepository = UserRepositoryImpl()
}