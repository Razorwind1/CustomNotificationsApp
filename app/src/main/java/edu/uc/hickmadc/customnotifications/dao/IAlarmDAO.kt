package edu.uc.hickmadc.customnotifications.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import androidx.room.Delete
import edu.uc.hickmadc.customnotifications.dto.Alarm
import kotlinx.coroutines.flow.Flow

@Dao
interface IAlarmDAO {

    @Query("SELECT * FROM alarm")
    fun getAllAlarms(): Flow<List<Alarm>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(alarm: Alarm)

    @Insert
    suspend fun save(alarm: Alarm)

    @Update
    suspend fun update(alarm: Alarm)

    @Delete
    suspend fun delete(alarm: Alarm)
}