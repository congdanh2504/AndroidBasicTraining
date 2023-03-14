package com.training.multipleviewholders

class ItemModel {
    companion object {
        fun getItems(): ArrayList<Item> = arrayListOf(
            Item("Mt. Kenya", "This is a mountain in Kenya 1", null, HasImage.FALSE),
            Item("Mt. Kenya", "This is a mountain in Kenya 2", null, HasImage.FALSE),
            Item("Mt. Kenya", "This is a mountain in Kenya 3", null, HasImage.FALSE),
            Item(
                "Mt. Kenya", "This is a mountain in Kenya 4", R.drawable.ic_launcher_background,
                HasImage.TRUE
            ),
            Item("Mt. Kenya", "This is a mountain in Kenya 5", null, HasImage.FALSE),
            Item(
                "Mt. Kenya", "This is a mountain in Kenya 6", R.drawable.ic_launcher_foreground,
                HasImage.TRUE
            ),
            Item("Mt. Kenya", "This is a mountain in Kenya 7", null, HasImage.FALSE),
            Item("Mt. Kenya", "This is a mountain in Kenya 8", null, HasImage.FALSE)
        )
    }
}