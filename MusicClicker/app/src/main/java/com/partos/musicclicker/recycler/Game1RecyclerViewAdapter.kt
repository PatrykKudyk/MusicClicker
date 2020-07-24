package com.partos.musicclicker.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.partos.musicclicker.MyApp
import com.partos.musicclicker.R
import com.partos.musicclicker.logic.MoneyFormatter
import com.partos.musicclicker.models.Row
import kotlinx.android.synthetic.main.recycler_row_instrument.view.*

class Game1RecyclerViewAdapter(val rowList: ArrayList<Row>) :
    RecyclerView.Adapter<Game1ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Game1ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val cell = inflater.inflate(R.layout.recycler_row_instrument, parent, false)
        return Game1ViewHolder(cell)
    }

    override fun getItemCount(): Int {
        return 13
    }

    override fun onBindViewHolder(holder: Game1ViewHolder, position: Int) {
        val image = holder.view.recycler_row_instrument_image
        val owned = holder.view.recycler_row_instrument_owned
        val income = holder.view.recycler_row_instrument_income
        val cost = holder.view.recycler_row_instrument_cost
        val upgrade = holder.view.recycler_row_instrument_upgrade
        val upgradeCost = holder.view.recycler_row_instrument_upgrade_cost
        val context = holder.view.context
        val moneyFormatter = MoneyFormatter(context)
        when (position) {
            0 -> image.setImageDrawable(context.getDrawable(R.drawable.lvl1001))
            1 -> image.setImageDrawable(context.getDrawable(R.drawable.lvl1002))
            2 -> image.setImageDrawable(context.getDrawable(R.drawable.lvl1003))
            3 -> image.setImageDrawable(context.getDrawable(R.drawable.lvl1004))
            4 -> image.setImageDrawable(context.getDrawable(R.drawable.lvl1005))
            5 -> image.setImageDrawable(context.getDrawable(R.drawable.lvl1006))
            6 -> image.setImageDrawable(context.getDrawable(R.drawable.lvl1007))
            7 -> image.setImageDrawable(context.getDrawable(R.drawable.lvl1008))
            8 -> image.setImageDrawable(context.getDrawable(R.drawable.lvl1009))
            9 -> image.setImageDrawable(context.getDrawable(R.drawable.lvl1010))
            10 -> image.setImageDrawable(context.getDrawable(R.drawable.lvl1011))
            11 -> image.setImageDrawable(context.getDrawable(R.drawable.lvl1012))
            12 -> image.setImageDrawable(context.getDrawable(R.drawable.lvl1013))
        }
        if (position != 0) {
            owned.text =
                context.getString(R.string.owned) + moneyFormatter.formatMoney(rowList[position].owned)
            income.text = moneyFormatter.formatMoney(rowList[position].income)
            cost.text = moneyFormatter.formatMoney(rowList[position].cost)
            upgradeCost.text = moneyFormatter.formatMoney(rowList[position].upgradeCost)
            if (MyApp.money >= rowList[position].upgradeCost) {
                upgrade.setBackgroundResource(R.drawable.button_background_green_dark_dark)
            } else {
                upgrade.setBackgroundResource(R.drawable.button_background_grey)
            }
            upgrade.setOnClickListener {
                if (MyApp.money >= rowList[position].upgradeCost) {
                    MyApp.money -= rowList[position].upgradeCost
                    if (MyApp.money >= rowList[position].upgradeCost) {
                        upgrade.setBackgroundResource(R.drawable.button_background_green_dark_dark)
                    } else {
                        upgrade.setBackgroundResource(R.drawable.button_background_grey)
                    }
                }
            }
        } else {
            holder.view.recycler_row_instrument_linear_first.visibility = View.VISIBLE
            holder.view.recycler_row_instrument_linear_normal.visibility = View.GONE
        }
    }

}

class Game1ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

}