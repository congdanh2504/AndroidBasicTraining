package com.training.multipleviewholders

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.training.multipleviewholders.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val landmarks = ItemModel.getItems()
        mainBinding.landmarkRecyclerview.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ItemAdapter(landmarks)
        }
    }
}