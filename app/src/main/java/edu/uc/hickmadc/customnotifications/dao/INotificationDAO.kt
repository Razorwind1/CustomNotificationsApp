package edu.uc.hickmadc.customnotifications.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import edu.uc.hickmadc.customnotifications.dto.Notification

@Dao
interface INotificationDAO {

    @Query("SELECT * FROM notification")
    fun getAllNotifications() : LiveData<List<Notification>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(notifications : ArrayList<Notification>)

    @Insert
    fun save(notification : Notification)

    @Delete
    fun delete(notification : Notification)

    /**
     * Test query
     * @return latest notification
     */
    @Query("SELECT * FROM notification ORDER BY notificationId DESC LIMIT 1")
    fun getLatestNotification() : Notification?
}