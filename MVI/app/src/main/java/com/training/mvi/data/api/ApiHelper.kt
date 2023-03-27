package com.training.mvi.data.api

import com.training.mvi.data.model.User

interface ApiHelper {

    suspend fun getUsers(): List<User>
}