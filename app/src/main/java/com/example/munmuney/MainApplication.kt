package com.example.munmuney

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by natasha.santoso on 16/10/20.
 */
@HiltAndroidApp
class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}