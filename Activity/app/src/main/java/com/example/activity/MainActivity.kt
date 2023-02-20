package com.example.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        log("On create")

        val button = findViewById<Button>(R.id.nextBtn)
        button.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        log("On start")
    }

    override fun onRestart() {
        super.onRestart()
        log("On restart")
    }

    override fun onPause() {
        super.onPause()
        log("On pause")
    }

    override fun onResume() {
        super.onResume()
        log("On resume")
    }

    override fun onDestroy() {
        super.onDestroy()
        log("On destroy")
    }

    override fun onStop() {
        super.onStop()
        log("On stop")
    }

    private fun log(message: String) {
        Toast.makeText(applicationContext, "Main activity: $message", Toast.LENGTH_SHORT).show()
    }
}