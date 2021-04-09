package edu.uc.hickmadc.customnotifications.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.uc.hickmadc.customnotifications.dto.Notification

@Database(entities=[Notification::class], version = 1)
abstract class NotificationDatabase : RoomDatabase() {
    abstract fun notificationDAO(): INotificationDAO
}