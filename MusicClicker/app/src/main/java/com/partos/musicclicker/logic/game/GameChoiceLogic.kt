package com.partos.musicclicker.logic.game

import android.content.Intent
import android.view.View
import android.widget.Button
import androidx.fragment.app.FragmentManager
import com.partos.musicclicker.R
import com.partos.musicclicker.activities.GameActivity
import com.partos.musicclicker.db.DataBaseHelper
import kotlinx.android.synthetic.main.fragment_game_choice.view.*

class GameChoiceLogic (val rootView: View, val fragmentManager: FragmentManager) {

    private lateinit var fastButton: Button
    private lateinit var longButton: Button
    private lateinit var endlessButton: Button

    fun initFragment() {
        attachViews()
        attachSounds()
        attachListeners()
    }

    private fun attachListeners() {
        fastButton.setOnClickListener {
            val intent = Intent(rootView.context, GameActivity::class.java)
            intent.putExtra("game", 1)
            rootView.context.startActivity(intent)
        }
        longButton.setOnClickListener {
            val intent = Intent(rootView.context, GameActivity::class.java)
            intent.putExtra("game", 2)
            rootView.context.startActivity(intent)
        }
        endlessButton.setOnClickListener {
            val intent = Intent(rootView.context, GameActivity::class.java)
            intent.putExtra("game", 3)
            rootView.context.startActivity(intent)
        }
    }

    private fun attachSounds() {
        val db = DataBaseHelper(rootView.context)
        val settings = db.getSettings()
        if (settings[0].sounds == 1) {
            fastButton.isSoundEffectsEnabled = true
            longButton.isSoundEffectsEnabled = true
            endlessButton.isSoundEffectsEnabled = true
        } else {
            fastButton.isSoundEffectsEnabled = false
            longButton.isSoundEffectsEnabled = false
            endlessButton.isSoundEffectsEnabled = false
        }
    }

    private fun attachViews() {
        fastButton = rootView.findViewById(R.id.game_choice_button_fast)
        longButton = rootView.findViewById(R.id.game_choice_button_long)
        endlessButton = rootView.findViewById(R.id.game_choice_button_endless)
    }
}