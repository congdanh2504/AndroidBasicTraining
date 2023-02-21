package com.example.services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.services.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.start.setOnClickListener {
            startService()
        }

        mainBinding.end.setOnClickListener {
            stopService()
        }
    }

    private fun startService() {
        val intent = Intent(this, MyForegroundService::class.java)
        intent.putExtra("data", mainBinding.edittext.text.toString())
        startService(intent)
    }

    private fun stopService() {
        val intent = Intent(this, MyForegroundService::class.java)
        stopService(intent)
    }

    override fun onDestroy() {
        stopService()
        super.onDestroy()
    }
}