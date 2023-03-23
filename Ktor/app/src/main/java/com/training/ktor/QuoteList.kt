package com.training.ktor

import kotlinx.serialization.Serializer

@kotlinx.serialization.Serializable
data class QuoteList(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<Result>,
    val totalCount: Int,
    val totalPages: Int
)