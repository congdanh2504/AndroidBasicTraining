package com.training.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isInvisible
import com.training.mvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MyContract.View {

    private lateinit var presenter: MyContract.Presenter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Create the presenter and model
        val model = MyModel()
        presenter = MyPresenter(this, model)
        // Load data from the presenter
        presenter.loadData()
    }

    override fun showData(data: List<String>) {
        var string = ""
        data.forEach {
            string += it + "\n"
        }
        binding.text.text = string
    }

    override fun showError(error: String) {
        binding.text.text = error
    }

    override fun showLoading() {
        binding.progress.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progress.visibility = View.INVISIBLE
    }
}