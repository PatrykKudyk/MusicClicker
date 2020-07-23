package com.partos.musicclicker.activities

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.partos.musicclicker.MyApp
import com.partos.musicclicker.R
import com.partos.musicclicker.db.DataBaseHelper
import com.partos.musicclicker.fragments.menu.MainMenuFragment
import com.partos.musicclicker.models.Settings

class MainActivity : AppCompatActivity() {

    private lateinit var mainMenuFragment: MainMenuFragment
    private lateinit var settings: ArrayList<Settings>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = DataBaseHelper(this)
        settings = db.getSettings()
        if (settings.size == 0) {
            db.addSettings(1, 1)
        }

        settings = db.getSettings()
        if (settings[0].music == 1) {
            MyApp.mediaPlayer = MediaPlayer.create(this, R.raw.background)
            MyApp.mediaPlayer.isLooping = true
            MyApp.mediaPlayer.start()
        }

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
        if (settings[0].music == 1) {
            MyApp.mediaPlayer.pause()
        }
        super.onPause()
    }

    override fun onResume() {
        if (settings[0].music == 1) {
            MyApp.mediaPlayer.start()
        }

        super.onResume()
    }
}