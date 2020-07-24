package com.partos.musicclicker.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.partos.musicclicker.R
import com.partos.musicclicker.fragments.game.GameEndlessFragment
import com.partos.musicclicker.fragments.game.GameLimitedFragment

class GameActivity : AppCompatActivity() {

    private lateinit var fragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        val gameType = intent.getSerializableExtra("game") as Int

        when (gameType) {
            1 -> fragment = GameLimitedFragment.newInstance(1)
            2 -> fragment = GameLimitedFragment.newInstance(2)
            3 -> fragment = GameEndlessFragment.newInstance()
        }

        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.enter_bottom_to_top,
                R.anim.exit_top_to_bottom,
                R.anim.enter_top_to_bottom,
                R.anim.exit_bottom_to_top
            )
            .add(R.id.game_frame_layout, fragment)
            .commit()
    }

    override fun onBackPressed() {

    }
}