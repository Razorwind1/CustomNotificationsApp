package edu.uc.hickmadc.customnotifications.service

import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import edu.uc.hickmadc.customnotifications.RetrofitClientInstance
import edu.uc.hickmadc.customnotifications.dao.ILocalNotificationDAO
import edu.uc.hickmadc.customnotifications.dao.INotificationDAO
import edu.uc.hickmadc.customnotifications.dao.NotificationDatabase
import edu.uc.hickmadc.customnotifications.dto.Notification
import kotlinx.coroutines.*

class NotificationService(application: Application) {
    private val application = application

    /**
     * Method for fetching data using retrofit
     * Might be deleted, not sure if we are implementing this
     */
    internal suspend fun fetchNotifications(title: String) {
        withContext(Dispatchers.IO) {
            val service = RetrofitClientInstance.retrofitInstance?.create(INotificationDAO::class.java)
            val notifications = async {service?.getAllNotifications()}

            updateLocalNotifications(notifications.await())
        }
    }


    /**
     * Store notifications locally using Room database
     */
    private suspend fun updateLocalNotifications(notifications: ArrayList<Notification>?) {
        try {
            var localNotificationDAO = getLocalNotificationDAO()
            localNotificationDAO.insertAll(notifications!!)
        }catch (e: Exception) {
            Log.e(TAG, e.message.toString())
        }
    }

    internal fun getLocalNotificationDAO(): ILocalNotificationDAO {
        val db = Room.databaseBuilder(application, NotificationDatabase::class.java, "myNotifications").build()
        val localNotificationDAO = db.localNotificationDAO()
        return localNotificationDAO
    }

    internal fun save(notification: Notification) {
        getLocalNotificationDAO().save(notification)
    }
}