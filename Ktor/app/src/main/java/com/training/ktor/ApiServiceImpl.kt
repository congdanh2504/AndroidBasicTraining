package com.training.ktor

import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import kotlin.text.get

class ApiServiceImpl(
    private val client: HttpClient
) : ApiService {

    override suspend fun getQuotes(): QuoteList {
        return client.get() { url(ApiRoutes.QUOTES) }
    }
}