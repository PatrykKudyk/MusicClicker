package com.partos.musicclicker.logic.game

import android.os.Handler
import android.view.View
import android.widget.Button
import androidx.viewpager.widget.ViewPager
import com.partos.musicclicker.R
import com.partos.musicclicker.activities.GameActivity
import com.partos.musicclicker.logic.TimerThread
import com.partos.musicclicker.models.Row
import com.partos.musicclicker.pager.GameLimitedViewPagerAdapter

class GameFastHandler(val rootView: View) {

    private lateinit var viewPager: ViewPager
    private lateinit var backButton: Button
    private var looperThread = TimerThread()


    fun initGame() {
        attachViews()
        looperThread.start()
        viewPager.adapter = GameLimitedViewPagerAdapter(rootView.context, createRowList())
        attachListeners()
        startTimer()
    }

    private fun startTimer() {
        var threadHandler = Handler(looperThread.looper)
        var time = 0
        threadHandler.post(object : Runnable {
            override fun run() {
                if (time == 20) {
                    time = 0
                    addMoney()
                    setMoney()
                    setIncome()
                }
                time++
                threadHandler.postDelayed(this, 100)
            }
        })
    }

    private fun addMoney() {

    }

    private fun setMoney() {

    }

    private fun setIncome() {

    }

    private fun attachListeners() {
        backButton.setOnClickListener {
            (rootView.context as GameActivity).finish()
        }
    }

    private fun createRowList(): ArrayList<ArrayList<Row>> {
        val finalList = ArrayList<ArrayList<Row>>()
        val lvl1List = ArrayList<Row>()
        lvl1List.add(Row(0, 0, 0, 0))
        lvl1List.add(Row(0, 1, 5, 30))
        lvl1List.add(Row(0, 3, 20, 150))
        lvl1List.add(Row(0, 10, 80, 750))
        lvl1List.add(Row(0, 30, 320, 3750))
        lvl1List.add(Row(0, 100, 1300, 19000))
        lvl1List.add(Row(0, 300, 5200, 94000))
        lvl1List.add(Row(0, 1000, 20000, 470000))
        lvl1List.add(Row(0, 3500, 85000, 2350000))
        lvl1List.add(Row(0, 12000, 330000, 11700000))
        lvl1List.add(Row(0, 40000, 1300000, 59000000))
        lvl1List.add(Row(0, 130000, 5300000, 295000000))
        lvl1List.add(Row(0, 400000, 21000000, 1500000000))
        finalList.add(lvl1List)
        return finalList
    }

    private fun attachViews() {
        viewPager = rootView.findViewById(R.id.game_limited_view_pager)
        backButton = rootView.findViewById(R.id.game_limited_button_back)
    }
}