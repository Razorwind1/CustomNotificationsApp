package edu.uc.hickmadc.customnotifications.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.uc.hickmadc.customnotifications.dto.Alarm

@Database(entities=arrayOf(Alarm::class), version=1)
abstract class AlarmDatabase : RoomDatabase() {
    abstract fun alarmDAO() : iAlarmDAO
}