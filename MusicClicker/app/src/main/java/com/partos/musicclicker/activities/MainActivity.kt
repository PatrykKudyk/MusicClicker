package com.partos.musicclicker.activities

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.partos.musicclicker.R

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaPlayer = MediaPlayer.create(this, R.raw.background)
        mediaPlayer.isLooping = true
        mediaPlayer.start()
    }

    override fun onPause() {
        if (mediaPlayer != null) {
            mediaPlayer.pause()
        }
        super.onPause()
    }

    override fun onResume() {
        if (mediaPlayer != null) {
            mediaPlayer.start()
        }
        super.onResume()
    }
}