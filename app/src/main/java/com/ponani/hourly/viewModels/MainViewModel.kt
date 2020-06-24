package com.ponani.hourly.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.ponani.hourly.database.HourlyDatabase
import com.ponani.hourly.database.HourlyItem
import com.ponani.hourly.database.HourlyRepo
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {

    private  val repo : HourlyRepo
    val hourList : LiveData<List<HourlyItem>>

    init {
        val hourlyDAO = HourlyDatabase.getDatabase(application,viewModelScope).hourlyDAO()
        repo = HourlyRepo(hourlyDAO)
        hourList = repo.hourList
    }

    fun deleteAll() = viewModelScope.launch {
        repo.deleteHourlyTable()
    }

    fun insertSampleData() = viewModelScope.launch {
        repo.insertSampleData()
    }
}