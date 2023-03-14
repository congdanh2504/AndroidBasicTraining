package com.training.multipleviewholders

data class Item(
    val title: String,
    val desc: String,
    var resource: Int?,
    val hasImage: HasImage
)