package com.partos.musicclicker.logic.game

import android.view.View
import androidx.viewpager.widget.ViewPager
import com.partos.musicclicker.R
import com.partos.musicclicker.pager.GameLimitedViewPagerAdapter

class GameFastHandler (val rootView: View) {

    private lateinit var viewPager: ViewPager

    fun initGame() {
        attachViews()
        viewPager.adapter = GameLimitedViewPagerAdapter(rootView.context)
    }

    private fun attachViews() {
        viewPager = rootView.findViewById(R.id.game_limited_view_pager)
    }
}