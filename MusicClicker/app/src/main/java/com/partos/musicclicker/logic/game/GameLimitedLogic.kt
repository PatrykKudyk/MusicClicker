package com.partos.musicclicker.logic.game

import android.view.View

class GameLimitedLogic(val rootView: View, private val gameType: Int) {

    fun initFragment() {
        if (gameType == 1) {
            val fastGameHandler = GameFastHandler(rootView)
            fastGameHandler.initGame()
        } else {
            val longGameHandler = GameLongHandler(rootView)
            longGameHandler.initGame()
        }
    }
}