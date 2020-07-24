package com.partos.musicclicker.pager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.PagerAdapter
import com.partos.flashback.recycler.MarginItemDecoration
import com.partos.musicclicker.R
import com.partos.musicclicker.models.Row
import com.partos.musicclicker.recycler.Game1RecyclerViewAdapter
import com.partos.musicclicker.recycler.Game2RecyclerViewAdapter
import com.partos.musicclicker.recycler.Game3RecyclerViewAdapter
import com.partos.musicclicker.recycler.Game4RecyclerViewAdapter
import kotlinx.android.synthetic.main.pager_cell.view.*

class GameLimitedViewPagerAdapter : PagerAdapter {

    val context: Context
    var rowList: ArrayList<ArrayList<Row>>

    constructor(context: Context, rowList: ArrayList<ArrayList<Row>>) : super() {
        this.context = context
        this.rowList = rowList
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean =
        view == `object` as ConstraintLayout

    override fun getCount(): Int {
        return 4
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view: View =
            inflater.inflate(R.layout.pager_cell, container, false)

        val layoutManager = LinearLayoutManager(this.context)
        val recyclerView = view.pager_cell_recycler
        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(MarginItemDecoration(12))
        when (position) {
            0 -> recyclerView.adapter = Game1RecyclerViewAdapter(rowList[0])
            1 -> recyclerView.adapter = Game2RecyclerViewAdapter()
            2 -> recyclerView.adapter = Game3RecyclerViewAdapter()
            3 -> recyclerView.adapter = Game4RecyclerViewAdapter()
        }

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }
}