package com.training.imageloadlib

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}