package edu.uc.hickmadc.customnotifications.service

import android.app.Application
import androidx.room.Room
import edu.uc.hickmadc.customnotifications.dao.iAlarmDAO
import edu.uc.hickmadc.customnotifications.dao.AlarmDatabase
import edu.uc.hickmadc.customnotifications.dto.Alarm

class AlarmService(private val application: Application) {

    /**
     * Store notifications locally using Room database
     */
    private fun updateNotifications(alarms: ArrayList<Alarm>?) {
        val alarmDAO = getAlarmDAO()
        alarms?.let{
            alarmDAO.insertAll(alarms)
        }
    }


    internal fun getAlarmDAO(): iAlarmDAO {
        val db = Room.databaseBuilder(application, AlarmDatabase::class.java, "myNotifications").build()
        return db.alarmDAO()
    }

    internal fun save(notification: Alarm) {
        getAlarmDAO().save(notification)
    }

    internal fun delete(notification: Alarm) {
        getAlarmDAO().delete(notification)
    }
}