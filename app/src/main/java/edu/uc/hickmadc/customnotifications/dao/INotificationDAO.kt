package edu.uc.hickmadc.customnotifications.dao

import androidx.room.Query
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update
import androidx.room.Delete
import androidx.room.OnConflictStrategy
import edu.uc.hickmadc.customnotifications.dto.Notification
import kotlinx.coroutines.flow.Flow

@Dao
interface INotificationDAO {

    @Query("SELECT * FROM notification")
    fun getAllNotifications(): Flow<List<Notification>>

    @Query("SELECT * FROM notification WHERE notificationId = :id")
    suspend fun get(id: Int): Notification

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(notification: Notification)

    @Insert
    suspend fun save(notification: Notification)

    @Update
    suspend fun update(notification: Notification)

    @Delete
    suspend fun delete(notification: Notification)
}