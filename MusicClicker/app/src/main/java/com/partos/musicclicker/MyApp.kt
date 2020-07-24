package com.partos.musicclicker

import android.app.Application
import android.media.MediaPlayer

class MyApp(): Application() {
    companion object {
        lateinit var mediaPlayer: MediaPlayer
        var money: Long = 0
    }
}