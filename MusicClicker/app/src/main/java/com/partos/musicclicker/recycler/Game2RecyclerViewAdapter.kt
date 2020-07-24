package com.partos.musicclicker.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.partos.musicclicker.R

class Game2RecyclerViewAdapter() : RecyclerView.Adapter<Game2ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Game2ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val cell = inflater.inflate(R.layout.recycler_row_instrument, parent, false)
        return Game2ViewHolder(cell)
    }

    override fun getItemCount(): Int {
        return 11
    }

    override fun onBindViewHolder(holder: Game2ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}

class Game2ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

}