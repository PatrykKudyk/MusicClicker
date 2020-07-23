package com.partos.musicclicker.logic

import android.view.View
import android.widget.Button
import androidx.fragment.app.FragmentManager
import com.partos.musicclicker.R

class MainMenuLogic(val rootView: View, val fragmentManager: FragmentManager) {

    private lateinit var playButton: Button
    private lateinit var settingsButton: Button
    private lateinit var creditsButton: Button

    fun initFragment() {
        attachViews()
        attachListeners()
    }

    private fun attachListeners() {
        playButton.setOnClickListener {

        }

        settingsButton.setOnClickListener {

        }

        creditsButton.setOnClickListener {

        }
    }

    private fun attachViews() {
        playButton = rootView.findViewById(R.id.main_menu_button_play)
        settingsButton = rootView.findViewById(R.id.main_menu_button_settings)
        creditsButton = rootView.findViewById(R.id.main_menu_button_credits)
    }
}