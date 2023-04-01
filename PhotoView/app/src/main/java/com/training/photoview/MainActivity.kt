package com.training.photoview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.github.chrisbanes.photoview.PhotoView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val photoView: PhotoView = findViewById(R.id.photoView)
        val imageUrl = "https://cdn.popsww.com/blog/sites/2/2022/02/Madara-Uchiha.jpg"

        Glide.with(this)
            .load(imageUrl)
            .into(photoView)
    }
}