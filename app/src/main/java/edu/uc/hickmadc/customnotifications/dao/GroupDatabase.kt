package edu.uc.hickmadc.customnotifications.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.uc.hickmadc.customnotifications.dto.Group

@Database(entities=arrayOf(Group::class), version = 1)
abstract class GroupDatabase : RoomDatabase() {
    abstract fun GroupDAO() : iGroupDAO
}