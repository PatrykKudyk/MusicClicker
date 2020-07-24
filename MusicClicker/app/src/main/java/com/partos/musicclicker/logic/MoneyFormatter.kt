package com.partos.musicclicker.logic

import android.content.Context
import com.partos.musicclicker.R

class MoneyFormatter(val context: Context) {

    fun formatMoney(money: Long): String {
        var moneyForm = ""
        when (money) {
            in 0..999 -> moneyForm = money.toString()
            in 1000..999999 -> {
                val money1 = money / 1000
                val money2 = money % 1000
                moneyForm = money1.toString() + "," + money2.toString() + "k"
            }
            in 1000000..999999999 -> {
                val money1 = money / 1000000
                val money2 = money % 1000000
                moneyForm = money1.toString() + "," + money2.toString() + "kk"
            }
            in 1000000000..999999999999 -> {
                val money1 = money / 1000000000
                val money2 = money % 1000000000
                moneyForm = money1.toString() + "," + money2.toString() + "kkk"
            }
            in 1000000000000..999999999999999 -> {
                val money1 = money / 1000000000000
                val money2 = money % 1000000000000
                moneyForm = money1.toString() + "," + money2.toString() + "kkkk"
            }
            in 1000000000000000..999999999999999999 -> {
                val money1 = money / 1000000000000000
                val money2 = money % 1000000000000000
                moneyForm = money1.toString() + "," + money2.toString() + "kkkkk"
            }
            else -> {
                moneyForm = context.getString(R.string.money_too_much)
            }
        }
        return moneyForm
    }
}