package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()
        val userDao = db.userDao()
        runBlocking(Dispatchers.IO) {
            val user = User("Danh", "Truong", Date())
            userDao.insertAll(user)
            val user2 = User("Minh", "Truong", Date())
            userDao.insertAndDeleteInTransaction(user2, user)
            val users: List<User> = userDao.getAll()
            Log.d("AAA", users.toString())
        }
    }
}