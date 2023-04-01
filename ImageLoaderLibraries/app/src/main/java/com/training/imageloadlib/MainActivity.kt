package com.training.imageloadlib

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import coil.transform.CircleCropTransformation
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.view.SimpleDraweeView
import com.squareup.picasso.Picasso
import com.training.imageloadlib.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageUrl = "https://cdn.popsww.com/blog/sites/2/2022/02/Madara-Uchiha.jpg"

        binding.coil.load(imageUrl) {
            transformations(CircleCropTransformation())
        }

        Glide.with(this)
            .load(imageUrl)
            .apply(RequestOptions().transform(CircleCrop()))
            .into(binding.glide)

        Picasso.get()
            .load(imageUrl)
            .into(binding.picasso)


        binding.fresco.setImageURI(Uri.parse(imageUrl))
    }
}