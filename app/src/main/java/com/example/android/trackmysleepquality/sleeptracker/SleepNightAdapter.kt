package com.example.android.trackmysleepquality.sleeptracker

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.database.SleepNight
import com.example.android.trackmysleepquality.TextItemViewHolder


class SleepNightAdapter: RecyclerView.Adapter<TextItemViewHolder>() {
    // define a data source
    var data = listOf<SleepNight>()

    // adding a custom sett
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    // tell recyclerView how may items there are
    override fun getItemCount() = data.size

    // draw item on screen
    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        var item = data[position]
        if (item.sleepQuality <= 1) {
            holder.textView.setTextColor(Color.RED)
        }else {
            holder.textView.setTextColor(Color.BLACK)
        }
        holder.textView.text = item.sleepQuality.toString()

    }

    // create a new view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.text_item_view, parent, false) as TextView
        return TextItemViewHolder(view)
    }

}
