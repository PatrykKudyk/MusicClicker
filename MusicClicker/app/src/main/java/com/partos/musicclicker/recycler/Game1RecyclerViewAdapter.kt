package com.partos.musicclicker.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.partos.musicclicker.R

class Game1RecyclerViewAdapter() : RecyclerView.Adapter<Game1ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Game1ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val cell = inflater.inflate(R.layout.recycler_row_instrument, parent, false)
        return Game1ViewHolder(cell)
    }

    override fun getItemCount(): Int {
        return 13
    }

    override fun onBindViewHolder(holder: Game1ViewHolder, position: Int) {
        when(position) {
            0 -> {

            }
        }
    }

}

class Game1ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

}