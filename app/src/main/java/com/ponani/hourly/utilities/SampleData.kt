package com.ponani.hourly.utilities

import com.ponani.hourly.database.HourlyItem
import java.util.*

object SampleData {
    
    fun getSampleData():MutableList<HourlyItem>?{
        var hourlySampleList :MutableList<HourlyItem> = mutableListOf()
        var calendar : Calendar = Calendar.getInstance()
        var date : Date = calendar.time

        //sample data
        hourlySampleList.add(HourlyItem(date,3,"cooking"))
        hourlySampleList.add(HourlyItem(date,1,"Reading"))
        hourlySampleList.add(HourlyItem(date,7,"Job Haunt"))
        return  hourlySampleList
    }
}