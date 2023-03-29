package com.training.cleanarchitecture.domain.usecase

import com.training.cleanarchitecture.domain.model.User

interface GetUserUseCase {
    operator fun invoke(id: Int): User
}