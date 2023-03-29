package com.training.cleanarchitecture.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.training.cleanarchitecture.domain.model.User
import com.training.cleanarchitecture.domain.usecase.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val getUserUseCase: GetUserUseCase) : ViewModel() {
    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    init {
        loadUser(1)
    }

    private fun loadUser(id: Int) {
        _user.value = getUserUseCase.invoke(id)
    }
}