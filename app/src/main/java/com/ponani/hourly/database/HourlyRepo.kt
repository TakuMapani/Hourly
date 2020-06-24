package com.ponani.hourly.database

import androidx.lifecycle.LiveData
import com.ponani.hourly.utilities.SampleData

class HourlyRepo(private val hourlyDAO: HourlyDAO) {

    val hourList : LiveData<List<HourlyItem>> = hourlyDAO.getHourlyList()

    suspend fun insertHourlyItem(hourlyItem: HourlyItem){
        hourlyDAO.insertHourlyItem(hourlyItem)
    }

    suspend fun deleteHourlyItem(hourlyItem: HourlyItem){
        hourlyDAO.deleteHourlyItem(hourlyItem)
    }

    suspend fun  deleteHourlyTable(){
        hourlyDAO.deleteHourlyTable()
    }

    suspend fun insertSampleData(){
        hourlyDAO.insertSampleData(SampleData.getSampleData())
    }
}