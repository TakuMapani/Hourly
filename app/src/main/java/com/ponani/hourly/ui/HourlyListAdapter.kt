package com.ponani.hourly.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.ponani.hourly.R
import com.ponani.hourly.database.HourlyItem
import java.text.SimpleDateFormat

class HourlyListAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<HourlyListAdapter.HourlyViewHolder>(){

    private  val inflater : LayoutInflater = LayoutInflater.from(context)
    private var hourlyItemList = emptyList<HourlyItem>()

    inner class HourlyViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        val tvSTime  = itemView.findViewById<TextView?>(R.id.tvTime)
        val tvSDate  = itemView.findViewById<TextView?>(R.id.tvDate)
        val tvSDescription  = itemView.findViewById<TextView?>(R.id.tvDescription)
        val tvSCategory  = itemView.findViewById<TextView?>(R.id.tvCategory)

        val fabHourlyItem : FloatingActionButton = itemView.findViewById(R.id.fabHourlyList)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HourlyListAdapter.HourlyViewHolder {
        val itemView = inflater.inflate(R.layout.hourly_recyclerview_item,parent,false)
        return HourlyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return hourlyItemList.size
    }

    override fun onBindViewHolder(holder: HourlyListAdapter.HourlyViewHolder, position: Int) {
        val current = hourlyItemList[position]

        //time format for tvSTime
        val timeFormat = SimpleDateFormat("HH")
        holder.tvSTime?.text = timeFormat.format(current.hourlyTime)

        //date format tvSTime
        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        holder.tvSDate?.text = dateFormat.format(current.hourlyTime)

        holder.tvSDescription?.text = current.hourDetails
        holder.tvSCategory?.setText(current.hourlyCategory.toString())
        holder.fabHourlyItem.isEnabled = false
    }

    internal fun setHourly(hourlyItemList:List<HourlyItem>){
        this.hourlyItemList = hourlyItemList
        notifyDataSetChanged()
    }

}