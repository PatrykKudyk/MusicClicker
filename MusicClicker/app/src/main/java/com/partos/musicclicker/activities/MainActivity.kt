package com.partos.musicclicker.activities

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.partos.musicclicker.R
import com.partos.musicclicker.fragments.menu.MainMenuFragment

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var mainMenuFragment: MainMenuFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaPlayer = MediaPlayer.create(this, R.raw.background)
        mediaPlayer.isLooping = true
        mediaPlayer.start()


        mainMenuFragment = MainMenuFragment.newInstance()

        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.enter_bottom_to_top,
                R.anim.exit_top_to_bottom,
                R.anim.enter_top_to_bottom,
                R.anim.exit_bottom_to_top
            )
            .add(R.id.main_frame_layout, mainMenuFragment)
            .commit()
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