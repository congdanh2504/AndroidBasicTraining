package com.training.mvp

interface MyContract {
    interface View {
        fun showData(data: List<String>)
        fun showError(error: String)
        fun showLoading()
        fun hideLoading()
    }

    interface Presenter {
        fun loadData()
    }

    interface Model {
        fun fetchData(listener: OnDataFetchedListener)

        interface OnDataFetchedListener {
            fun onSuccess(data: List<String>)
            fun onError(error: String)
        }
    }
}