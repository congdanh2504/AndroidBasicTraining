package com.training.mvp

class MyModel : MyContract.Model {
    override fun fetchData(listener: MyContract.Model.OnDataFetchedListener) {
        // Fetch data from a remote server
        val data = listOf("Item 1", "Item 2", "Item 3")

        // Notify the listener of the results
        listener.onSuccess(data)
    }
}