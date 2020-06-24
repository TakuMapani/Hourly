package com.ponani.hourly.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ponani.budgeter.database.DateTypeConverter
import kotlinx.coroutines.CoroutineScope

@Database(entities = arrayOf(HourlyItem::class), version = 1, exportSchema = false)
@TypeConverters(DateTypeConverter::class)
abstract class HourlyDatabase: RoomDatabase() {
    abstract fun hourlyDAO(): HourlyDAO

    companion object {
        //singleton for preventing multiple instances of the database
        @Volatile
        private var INSTANCE: HourlyDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): HourlyDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return  tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HourlyDatabase::class.java,
                    "hourly_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}