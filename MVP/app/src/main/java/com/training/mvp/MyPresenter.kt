package com.training.mvp

class MyPresenter(private val view: MyContract.View, private val model: MyContract.Model) :
    MyContract.Presenter {
    override fun loadData() {
        // Show a loading indicator on the view
        view.showLoading()

        // Fetch data from the model
        model.fetchData(object : MyContract.Model.OnDataFetchedListener {
            override fun onSuccess(data: List<String>) {
                // Hide the loading indicator and show the data on the view
                view.hideLoading()
                view.showData(data)
            }

            override fun onError(error: String) {
                // Hide the loading indicator and show an error message on the view
                view.hideLoading()
                view.showError(error)
            }
        })
    }
}