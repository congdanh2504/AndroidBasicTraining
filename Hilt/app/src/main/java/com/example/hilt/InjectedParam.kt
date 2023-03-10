package com.example.hilt

import javax.inject.Inject

class InjectedParam @Inject constructor()  {

    fun hello(): String {
        return "Hello world"
    }
}