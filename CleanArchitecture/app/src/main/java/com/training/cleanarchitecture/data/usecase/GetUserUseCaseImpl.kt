package com.training.cleanarchitecture.data.usecase

import com.training.cleanarchitecture.domain.model.User
import com.training.cleanarchitecture.domain.repository.UserRepository
import com.training.cleanarchitecture.domain.usecase.GetUserUseCase
import javax.inject.Inject

class GetUserUseCaseImpl @Inject constructor(private val userRepository: UserRepository) : GetUserUseCase {
    override operator fun invoke(id: Int): User {
        return userRepository.getUser(id)
    }
}