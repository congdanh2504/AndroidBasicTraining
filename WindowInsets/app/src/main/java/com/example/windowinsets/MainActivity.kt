package com.example.windowinsets

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.ViewGroup.MarginLayoutParams
import android.view.WindowInsets.Type
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.*
import com.example.windowinsets.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("WrongConstant")
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            val params: MarginLayoutParams = binding.root.layoutParams as MarginLayoutParams
            params.topMargin = insets.top
            params.bottomMargin = insets.bottom
            binding.root.layoutParams = params
            WindowInsetsCompat.CONSUMED
        }
        val windowInsetsController =
            ViewCompat.getWindowInsetsController(window.decorView)

        // Hide the system bars.
        windowInsetsController?.hide(Type.systemBars())

        // Show the system bars.
        windowInsetsController?.show(Type.systemBars())
    }
}