package com.training.mvi.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.training.mvi.data.api.ApiHelperImpl
import com.training.mvi.data.api.RetrofitBuilder
import com.training.mvi.data.model.User
import com.training.mvi.databinding.ActivityMainBinding
import com.training.mvi.ui.main.adapter.MainAdapter
import com.training.mvi.ui.main.intent.MainIntent
import com.training.mvi.ui.main.viewmodel.MainViewModel
import com.training.mvi.ui.main.viewstate.MainState
import com.training.mvi.util.ViewModelFactory
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private var adapter = MainAdapter(arrayListOf())
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        setupUI()
        setupViewModel()
        observeViewModel()
        setupClicks()
    }

    private fun setupClicks() {
        mainBinding.buttonFetchUser.setOnClickListener {
            lifecycleScope.launch {
                mainViewModel.userIntent.send(MainIntent.FetchUser)
            }
        }
    }


    private fun setupUI() {
        mainBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        mainBinding.recyclerView.run {
            addItemDecoration(
                DividerItemDecoration(
                    mainBinding.recyclerView.context,
                    (mainBinding.recyclerView.layoutManager as LinearLayoutManager).orientation
                )
            )
        }
        mainBinding.recyclerView.adapter = adapter
    }


    private fun setupViewModel() {
        mainViewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                ApiHelperImpl(
                    RetrofitBuilder.apiService
                )
            )
        )[MainViewModel::class.java]
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            mainViewModel.state.collect {
                when (it) {
                    is MainState.Idle -> {

                    }
                    is MainState.Loading -> {
                        mainBinding.buttonFetchUser.visibility = View.GONE
                        mainBinding.progressBar.visibility = View.VISIBLE
                    }

                    is MainState.Users -> {
                        mainBinding.progressBar.visibility = View.GONE
                        mainBinding.buttonFetchUser.visibility = View.GONE
                        renderList(it.user)
                    }
                    is MainState.Error -> {
                        mainBinding.progressBar.visibility = View.GONE
                        mainBinding.buttonFetchUser.visibility = View.VISIBLE
                        Toast.makeText(this@MainActivity, it.error, Toast.LENGTH_LONG).show()
                    }
                    else -> {}
                }
            }
        }
    }

    private fun renderList(users: List<User>) {
        mainBinding.recyclerView.visibility = View.VISIBLE
        users.let { listOfUsers -> listOfUsers.let { adapter.addData(it) } }
        adapter.notifyDataSetChanged()
    }
}