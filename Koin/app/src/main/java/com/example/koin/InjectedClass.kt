package com.example.koin

class InjectedClass(private val subclass: InjectedParam) {

    fun hello() = subclass.hello()
}