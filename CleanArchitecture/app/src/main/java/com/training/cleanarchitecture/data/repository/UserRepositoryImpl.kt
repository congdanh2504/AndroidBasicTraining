package com.training.cleanarchitecture.data.repository

import com.training.cleanarchitecture.domain.model.User
import com.training.cleanarchitecture.domain.repository.UserRepository

class UserRepositoryImpl : UserRepository {
    override fun getUser(id: Int): User {
        // get user from database or API
        return User(id, "John Doe")
    }
}