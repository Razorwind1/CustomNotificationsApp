package edu.uc.hickmadc.customnotifications.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import edu.uc.hickmadc.customnotifications.dto.Notification

@Dao
interface ILocalNotificationDAO {

    @Query("SELECT * FROM notification")
    fun getAllNotifications() : LiveData<List<Notification>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(notifications : ArrayList<Notification>)

    @Delete
    fun delete(notification : Notification)

    @Insert
    fun save(notification : Notification)
}