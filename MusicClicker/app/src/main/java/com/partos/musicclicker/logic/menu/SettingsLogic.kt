package com.partos.musicclicker.logic.menu

import android.media.MediaPlayer
import android.view.View
import android.widget.ImageView
import androidx.cardview.widget.CardView
import com.partos.musicclicker.MyApp
import com.partos.musicclicker.R
import com.partos.musicclicker.db.DataBaseHelper

class SettingsLogic(val rootView: View) {

    private val db = DataBaseHelper(rootView.context)
    private lateinit var musicImage: ImageView
    private lateinit var soundsImage: ImageView
    private lateinit var musicCard: CardView
    private lateinit var soundsCard: CardView

    fun initFragment() {
        attachViews()
        initImages()
        initListeners()
    }

    private fun initListeners() {
        musicCard.setOnClickListener {
            val settings = db.getSettings()
            if (settings[0].music == 1) {
                musicImage.setImageDrawable(rootView.context.getDrawable(R.drawable.ic_not_checked))
                settings[0].music = 0
                db.updateSettings(settings[0])
                MyApp.mediaPlayer.stop()
                MyApp.mediaPlayer.release()
            } else {
                musicImage.setImageDrawable(rootView.context.getDrawable(R.drawable.ic_checked))
                settings[0].music = 1
                db.updateSettings(settings[0])
                MyApp.mediaPlayer = MediaPlayer.create(rootView.context, R.raw.background)
                MyApp.mediaPlayer.isLooping = true
                MyApp.mediaPlayer.start()
            }
        }

        soundsCard.setOnClickListener {
            val settings = db.getSettings()
            if (settings[0].sounds == 1) {
                soundsImage.setImageDrawable(rootView.context.getDrawable(R.drawable.ic_not_checked))
                settings[0].sounds = 0
                db.updateSettings(settings[0])
            } else {
                soundsImage.setImageDrawable(rootView.context.getDrawable(R.drawable.ic_checked))
                settings[0].sounds = 1
                db.updateSettings(settings[0])
            }
        }
    }

    private fun initImages() {
        val settings = db.getSettings()
        if (settings[0].music == 1) {
            musicImage.setImageDrawable(rootView.context.getDrawable(R.drawable.ic_checked))
        } else {
            musicImage.setImageDrawable(rootView.context.getDrawable(R.drawable.ic_not_checked))
        }
        if (settings[0].sounds == 1) {
            soundsImage.setImageDrawable(rootView.context.getDrawable(R.drawable.ic_checked))
        } else {
            soundsImage.setImageDrawable(rootView.context.getDrawable(R.drawable.ic_not_checked))
        }
    }

    private fun attachViews() {
        musicImage = rootView.findViewById(R.id.settings_image_music)
        soundsImage = rootView.findViewById(R.id.settings_image_sounds)
        musicCard = rootView.findViewById(R.id.settings_card_music)
        soundsCard = rootView.findViewById(R.id.settings_card_sounds)
    }
}