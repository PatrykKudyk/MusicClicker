package com.partos.musicclicker.logic.game

import android.view.View
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.partos.musicclicker.R
import com.partos.musicclicker.activities.GameActivity
import com.partos.musicclicker.models.Row
import com.partos.musicclicker.pager.GameLimitedViewPagerAdapter

class GameFastHandler (val rootView: View) {

    private lateinit var viewPager: ViewPager
    private lateinit var backButton: Button

    fun initGame() {
        attachViews()
        viewPager.adapter = GameLimitedViewPagerAdapter(rootView.context, createRowList())
        attachListeners()
    }

    private fun attachListeners() {
        backButton.setOnClickListener {
            (rootView.context as GameActivity).finish()
        }
    }

    private fun createRowList(): ArrayList<ArrayList<Row>> {
        val finalList = ArrayList<ArrayList<Row>>()
        val lvl1List = ArrayList<Row>()
        lvl1List.add(Row(0,0,0,0))
        lvl1List.add(Row(0,5,30,500))
        lvl1List.add(Row(0,))
        finalList.add(lvl1List)
        return finalList
    }

    private fun attachViews() {
        viewPager = rootView.findViewById(R.id.game_limited_view_pager)
        backButton = rootView.findViewById(R.id.game_limited_button_back)
    }
}