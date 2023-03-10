package com.example.hilt

import javax.inject.Inject

class InjectedClass @Inject constructor(
    private val param: InjectedParam
) {

    fun hello() = param.hello()
}