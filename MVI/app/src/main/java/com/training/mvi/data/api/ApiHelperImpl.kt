package com.training.mvi.data.api

import com.training.mvi.data.model.User

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    override suspend fun getUsers(): List<User> = apiService.getUsers()
}