package com.training.nestedrecyclerview

data class ParentItem (
    var parentItemTitle: String,
    var childItemList: List<ChildItem>
)