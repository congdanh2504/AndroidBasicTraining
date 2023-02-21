package com.example.services

import android.app.Service
import android.content.Intent
import android.os.*
import android.util.Log
import android.widget.Toast
import java.lang.Process

class MyBackgroundService: Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Thread() {
            while (true) {
                Log.d("Service", "Service is running...")
                Thread.sleep(2000)
            }
        }.start()

        return START_NOT_STICKY
    }

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        Log.d("Service", "Service destroyed!")
        super.onDestroy()
    }
}