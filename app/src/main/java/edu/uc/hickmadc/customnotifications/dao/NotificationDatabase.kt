package edu.uc.hickmadc.customnotifications.dao

import edu.uc.hickmadc.customnotifications.dto.Notification
import androidx.room.*

@Database(entities=arrayOf(Notification::class), version = 1)
abstract class NotificationDatabase : RoomDatabase() {
    abstract fun localNotificationDAO() : ILocalNotificationDAO
}