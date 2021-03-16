package edu.uc.hickmadc.customnotifications.service

import android.app.Application
import androidx.room.Room
import edu.uc.hickmadc.customnotifications.dao.INotificationDAO
import edu.uc.hickmadc.customnotifications.dao.NotificationDatabase
import edu.uc.hickmadc.customnotifications.dto.Notification

class NotificationService(private val application: Application) {

    /**
     * Store notifications locally using Room database
     */
    private fun updateNotifications(notifications: ArrayList<Notification>?) {
        val notificationDAO = getNotificationDAO()
        notifications?.let{
            notificationDAO.insertAll(notifications)
        }
    }


    internal fun getNotificationDAO(): INotificationDAO {
        val db = Room.databaseBuilder(application, NotificationDatabase::class.java, "myNotifications").build()
        return db.notificationDAO()
    }

    internal fun save(notification: Notification) {
        getNotificationDAO().save(notification)
    }

    internal fun delete(notification: Notification) {
        getNotificationDAO().delete(notification)
    }
}