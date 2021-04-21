package edu.uc.hickmadc.customnotifications.service

import edu.uc.hickmadc.customnotifications.dao.INotificationDAO
import edu.uc.hickmadc.customnotifications.dto.Notification
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NotificationService @Inject constructor(
    private val notificationDao: INotificationDAO
) {

    fun getNotifications() = notificationDao.getAllNotifications()

    suspend fun get(id: Int) = notificationDao.get(id)

    suspend fun save(notification: Notification) {
        notificationDao.save(notification)
    }

    suspend fun delete(notification: Notification) {
        notificationDao.delete(notification)
    }

    suspend fun update(notification: Notification) {
        notificationDao.update(notification)
    }
}