package com.ponani.hourly.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface HourlyDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHourlyItem(spendingItem: HourlyItem)

    @Insert
    suspend fun insertSampleData(spendingItemList: MutableList<HourlyItem>?)

    @Query("SELECT * FROM hourlytable")
    fun getHourlyList(): LiveData<List<HourlyItem>>

    @Delete
    suspend fun deleteHourlyItem(hourlyItem: HourlyItem)

    @Query("DELETE FROM hourlytable")
    suspend fun deleteHourlyTable()
}