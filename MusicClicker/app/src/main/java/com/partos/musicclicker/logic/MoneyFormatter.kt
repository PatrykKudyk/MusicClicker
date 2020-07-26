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
                var money2 = money % 1000
                if (money2 % 100 == 0L) {
                    money2 /= 100
                } else if (money2 % 10 == 0L) {
                    money2 /= 10
                }
                moneyForm = money1.toString() + "," + money2.toString() + " k"
            }
            in 1000000..999999999 -> {
                val money1 = money / 1000000
                var money2 = money % 1000000
                when {
                    money2 % 100000 == 0L -> {
                        money2 /= 100000
                    }
                    money2 % 10000 == 0L -> {
                        money2 /= 10000
                    }
                    money2 % 1000 == 0L -> {
                        money2 /= 1000
                    }
                    money2 % 100 == 0L -> {
                        money2 /= 100
                    }
                    money2 % 10 == 0L -> {
                        money2 /= 10
                    }
                }
                moneyForm = money1.toString() + "," + money2.toString() + " kk"
            }
            in 1000000000..999999999999 -> {
                val money1 = money / 1000000000
                var money2 = money % 1000000000
                when {
                    money2 % 100000000 == 0L -> {
                        money2 /= 100000000
                    }
                    money2 % 10000000 == 0L -> {
                        money2 /= 10000000
                    }
                    money2 % 1000000 == 0L -> {
                        money2 /= 1000000
                    }
                    money2 % 100000 == 0L -> {
                        money2 /= 100000
                    }
                    money2 % 10000 == 0L -> {
                        money2 /= 10000
                    }
                    money2 % 1000 == 0L -> {
                        money2 /= 1000
                    }
                    money2 % 100 == 0L -> {
                        money2 /= 100
                    }
                    money2 % 10 == 0L -> {
                        money2 /= 10
                    }
                }
                moneyForm = money1.toString() + "," + money2.toString() + " kkk"
            }
            in 1000000000000..999999999999999 -> {
                val money1 = money / 1000000000000
                var money2 = money % 1000000000000
                when {
                    money2 % 100000000000 == 0L -> {
                        money2 /= 100000000000
                    }
                    money2 % 10000000000 == 0L -> {
                        money2 /= 10000000000
                    }
                    money2 % 1000000000 == 0L -> {
                        money2 /= 1000000000
                    }
                    money2 % 100000000 == 0L -> {
                        money2 /= 100000000
                    }
                    money2 % 10000000 == 0L -> {
                        money2 /= 10000000
                    }
                    money2 % 1000000 == 0L -> {
                        money2 /= 1000000
                    }
                    money2 % 100000 == 0L -> {
                        money2 /= 100000
                    }
                    money2 % 10000 == 0L -> {
                        money2 /= 10000
                    }
                    money2 % 1000 == 0L -> {
                        money2 /= 1000
                    }
                    money2 % 100 == 0L -> {
                        money2 /= 100
                    }
                    money2 % 10 == 0L -> {
                        money2 /= 10
                    }
                }
                moneyForm = money1.toString() + "," + money2.toString() + " kkkk"
            }
            in 1000000000000000..999999999999999999 -> {
                val money1 = money / 1000000000000000
                var money2 = money % 1000000000000000
                when {
                    money2 % 100000000000000 == 0L -> {
                        money2 /= 100000000000000
                    }
                    money2 % 10000000000000 == 0L -> {
                        money2 /= 10000000000000
                    }
                    money2 % 1000000000000 == 0L -> {
                        money2 /= 1000000000000
                    }
                    money2 % 100000000000 == 0L -> {
                        money2 /= 100000000000
                    }
                    money2 % 10000000000 == 0L -> {
                        money2 /= 10000000000
                    }
                    money2 % 1000000000 == 0L -> {
                        money2 /= 1000000000
                    }
                    money2 % 100000000 == 0L -> {
                        money2 /= 100000000
                    }
                    money2 % 10000000 == 0L -> {
                        money2 /= 10000000
                    }
                    money2 % 1000000 == 0L -> {
                        money2 /= 1000000
                    }
                    money2 % 100000 == 0L -> {
                        money2 /= 100000
                    }
                    money2 % 10000 == 0L -> {
                        money2 /= 10000
                    }
                    money2 % 1000 == 0L -> {
                        money2 /= 1000
                    }
                    money2 % 100 == 0L -> {
                        money2 /= 100
                    }
                    money2 % 10 == 0L -> {
                        money2 /= 10
                    }
                }
                moneyForm = money1.toString() + "," + money2.toString() + " kkkkk"
            }
            else -> {
                moneyForm = context.getString(R.string.money_too_much)
            }
        }
        return moneyForm
    }
}