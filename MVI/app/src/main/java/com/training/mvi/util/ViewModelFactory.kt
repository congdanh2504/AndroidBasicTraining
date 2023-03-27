package com.training.mvi.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.training.mvi.data.api.ApiHelper
import com.training.mvi.data.repository.MainRepository
import com.training.mvi.ui.main.viewmodel.MainViewModel


class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}