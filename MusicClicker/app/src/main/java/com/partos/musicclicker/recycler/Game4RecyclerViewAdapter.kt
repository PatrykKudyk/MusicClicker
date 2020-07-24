package com.partos.musicclicker.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.partos.musicclicker.R

class Game4RecyclerViewAdapter() : RecyclerView.Adapter<Game4ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Game4ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val cell = inflater.inflate(R.layout.recycler_row_instrument, parent, false)
        return Game4ViewHolder(cell)
    }

    override fun getItemCount(): Int {
        return 12
    }

    override fun onBindViewHolder(holder: Game4ViewHolder, position: Int) {

    }

}

class Game4ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

}