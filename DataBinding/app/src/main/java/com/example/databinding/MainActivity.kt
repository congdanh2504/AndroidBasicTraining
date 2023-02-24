package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: NotesViewModel
    private lateinit var databinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        databinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(NotesViewModel::class.java)
        databinding.notesViewModel = viewModel
        databinding.lifecycleOwner = this
        viewModel.list.observe(this) {
            databinding.content.text = it.toString()
        }
        viewModel.isStringEmpty.observe(this) {
            if (it == true) {
                Toast.makeText(this, "No Notes Detected", Toast.LENGTH_SHORT).show();
            }
        }
    }
}