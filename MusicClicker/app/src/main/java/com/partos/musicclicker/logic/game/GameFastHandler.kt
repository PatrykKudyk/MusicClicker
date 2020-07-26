package com.partos.musicclicker.logic.game

import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.partos.flashback.recycler.MarginItemDecoration
import com.partos.musicclicker.MyApp
import com.partos.musicclicker.R
import com.partos.musicclicker.activities.GameActivity
import com.partos.musicclicker.logic.MoneyFormatter
import com.partos.musicclicker.logic.TimerThread
import com.partos.musicclicker.models.Items
import com.partos.musicclicker.models.Row
import com.partos.musicclicker.recycler.Game1RecyclerViewAdapter

class GameFastHandler(val rootView: View) {

    private lateinit var recycler: RecyclerView
    private lateinit var backButton: Button
    private lateinit var incomeText: TextView
    private lateinit var moneyText: TextView
    private var looperThread = TimerThread()
    private lateinit var moneyFormatter: MoneyFormatter


    fun initGame() {
        attachViews()
        initItemsList()
        looperThread.start()
        moneyFormatter = MoneyFormatter(rootView.context)
        MyApp.money = 0L
        MyApp.income = 0L
        initViews()
        attachListeners()
        Handler().postDelayed({
            startTimer()
        }, 300)
    }

    private fun initViews() {
        val layoutManager = LinearLayoutManager(rootView.context)
        recycler.layoutManager = layoutManager
        recycler.addItemDecoration(MarginItemDecoration(12))
        recycler.adapter = Game1RecyclerViewAdapter(createRowList())
        moneyText.text = MyApp.money.toString()
        incomeText.text = MyApp.income.toString()
    }

    private fun initItemsList() {
        val ownedList = ArrayList<Long>()
        for (i in 0 until 13) {
            ownedList.add(0L)
        }
        val incomeList = ArrayList<Long>()
        incomeList.add(0)
        incomeList.add(1)
        incomeList.add(3)
        incomeList.add(10)
        incomeList.add(30)
        incomeList.add(100)
        incomeList.add(300)
        incomeList.add(1000)
        incomeList.add(3500)
        incomeList.add(12000)
        incomeList.add(40000)
        incomeList.add(130000)
        incomeList.add(400000)
        MyApp.itemsLimited = Items(ownedList, incomeList)
    }

    private fun startTimer() {
        var threadHandler = Handler(looperThread.looper)
        var time = 0
        threadHandler.post(object : Runnable {
            override fun run() {
                if (time == 10) {
                    time = 0
                    addMoney()
                    (rootView.context as GameActivity).runOnUiThread {
                        recycler.adapter?.notifyDataSetChanged()
                    }
                }
                setIncome()
                setMoney()

                time++
                if (!isEnd()) {
                    threadHandler.postDelayed(this, 100)
                } else {
                    
                }
            }
        })
    }

    private fun isEnd(): Boolean {
        if (MyApp.money >= 5000000L) {
            return true
        }
        return false
    }

    private fun addMoney() {
        var moneyToAdd = 0L
        for (i in 0 until 13) {
            moneyToAdd += MyApp.itemsLimited.ownedList[i] * MyApp.itemsLimited.incomeList[i]
        }
        MyApp.money += moneyToAdd
    }

    private fun setMoney() {
        moneyText.text = moneyFormatter.formatMoney(MyApp.money)
    }

    private fun setIncome() {
        var income = 0L
        for (i in 0 until 13) {
            income += MyApp.itemsLimited.ownedList[i] * MyApp.itemsLimited.incomeList[i]
        }
        MyApp.income = income
        incomeText.text = moneyFormatter.formatMoney(MyApp.income)
    }

    private fun attachListeners() {
        backButton.setOnClickListener {
            (rootView.context as GameActivity).finish()
        }
    }

    private fun createRowList(): ArrayList<Row> {
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
        return lvl1List
    }

    private fun attachViews() {
        recycler = rootView.findViewById(R.id.game_limited_recycler)
        backButton = rootView.findViewById(R.id.game_limited_button_back)
        incomeText = rootView.findViewById(R.id.game_limited_income)
        moneyText = rootView.findViewById(R.id.game_limited_money)
    }
}