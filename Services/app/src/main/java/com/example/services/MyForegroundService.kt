package com.example.services

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyForegroundService: Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val data = intent!!.getStringExtra("data")
        sendNotification(data!!)
        return super.onStartCommand(intent, flags, startId)
    }

    private fun sendNotification(data: String) {
        try {
            val intent = Intent(this, MainActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

            val notification  = Notification.Builder(this, MyApplication.CHANNEL_ID)
                .setContentTitle("Title")
                .setContentText(data)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentIntent(pendingIntent)
                .build()

            startForeground(1001, notification)
        } catch (e: java.lang.Exception) {
            Log.d("Service", "Error: ${e.message}")
        }
    }

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        Log.d("Service", "Service destroyed!!")
        super.onDestroy()
    }
}