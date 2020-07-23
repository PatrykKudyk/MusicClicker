package com.partos.musicclicker.logic.menu

import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.FragmentManager
import com.partos.musicclicker.R
import com.partos.musicclicker.db.DataBaseHelper
import com.partos.musicclicker.fragments.menu.CreditsFragment
import com.partos.musicclicker.fragments.game.GameChoiceFragment
import com.partos.musicclicker.fragments.menu.SettingsFragment

class MainMenuLogic(val rootView: View, val fragmentManager: FragmentManager) {

    private lateinit var playButton: Button
    private lateinit var settingsButton: ImageView
    private lateinit var creditsButton: ImageView

    fun initFragment() {
        attachViews()
        applySounds()
        attachListeners()
    }

    private fun applySounds() {
        val db = DataBaseHelper(rootView.context)
        val settings = db.getSettings()
        if (settings[0].sounds == 1) {
            playButton.isSoundEffectsEnabled = true
            settingsButton.isSoundEffectsEnabled = true
            creditsButton.isSoundEffectsEnabled = true
        } else {
            playButton.isSoundEffectsEnabled = false
            settingsButton.isSoundEffectsEnabled = false
            creditsButton.isSoundEffectsEnabled = false
        }
    }

    private fun attachListeners() {
        playButton.setOnClickListener {
            val fragment = GameChoiceFragment.newInstance()
            fragmentManager
                .beginTransaction()
                .setCustomAnimations(
                    R.anim.enter_left_to_right, R.anim.exit_right_to_left,
                    R.anim.enter_right_to_left, R.anim.exit_left_to_right
                )
                .replace(R.id.main_frame_layout, fragment)
                .addToBackStack(GameChoiceFragment.toString())
                .commit()
        }

        settingsButton.setOnClickListener {
            val fragment = SettingsFragment.newInstance()
            fragmentManager
                .beginTransaction()
                .setCustomAnimations(
                    R.anim.enter_left_to_right, R.anim.exit_right_to_left,
                    R.anim.enter_right_to_left, R.anim.exit_left_to_right
                )
                .replace(R.id.main_frame_layout, fragment)
                .addToBackStack(SettingsFragment.toString())
                .commit()
        }

        creditsButton.setOnClickListener {
            val fragment = CreditsFragment.newInstance()
            fragmentManager
                .beginTransaction()
                .setCustomAnimations(
                    R.anim.enter_left_to_right, R.anim.exit_right_to_left,
                    R.anim.enter_right_to_left, R.anim.exit_left_to_right
                )
                .replace(R.id.main_frame_layout, fragment)
                .addToBackStack(CreditsFragment.toString())
                .commit()
        }
    }

    private fun attachViews() {
        playButton = rootView.findViewById(R.id.main_menu_button_play)
        settingsButton = rootView.findViewById(R.id.main_menu_button_settings)
        creditsButton = rootView.findViewById(R.id.main_menu_button_credits)
    }
}