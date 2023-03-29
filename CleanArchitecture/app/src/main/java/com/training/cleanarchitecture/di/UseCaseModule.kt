package com.training.cleanarchitecture.di

import com.training.cleanarchitecture.data.usecase.GetUserUseCaseImpl
import com.training.cleanarchitecture.domain.repository.UserRepository
import com.training.cleanarchitecture.domain.usecase.GetUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetUserUseCase(userRepository: UserRepository): GetUserUseCase = GetUserUseCaseImpl(userRepository)
}