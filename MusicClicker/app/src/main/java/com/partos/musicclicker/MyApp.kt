package com.partos.musicclicker

import android.app.Application
import android.media.MediaPlayer
import com.partos.musicclicker.models.Items

class MyApp(): Application() {
    companion object {
        lateinit var mediaPlayer: MediaPlayer
        var money: Long = 0
        var income: Long = 0
        lateinit var itemsLimited: Items
    }
}