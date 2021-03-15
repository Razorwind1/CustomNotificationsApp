package edu.uc.hickmadc.customnotifications.dao

import androidx.room.*
import edu.uc.hickmadc.customnotifications.dto.Notification

@Database(entities=arrayOf(Notification::class), version = 1)
abstract class NotificationDatabase : RoomDatabase() {
    abstract fun notificationDAO(): INotificationDAO
}