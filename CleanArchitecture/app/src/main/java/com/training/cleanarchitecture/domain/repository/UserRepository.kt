package com.training.cleanarchitecture.domain.repository

import com.training.cleanarchitecture.domain.model.User

interface UserRepository {
    fun getUser(id: Int): User
}