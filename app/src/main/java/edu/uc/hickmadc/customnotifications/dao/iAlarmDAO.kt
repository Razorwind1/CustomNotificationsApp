package edu.uc.hickmadc.customnotifications.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import edu.uc.hickmadc.customnotifications.dto.Alarm

@Dao
interface iAlarmDAO {

    @Query("SELECT * FROM alarm")
    fun getAllAlarms() : LiveData<List<Alarm>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(alarm: ArrayList<Alarm>)

    @Delete
    fun delete(alarm: Alarm)

    @Insert
    fun save(alarm: Alarm)
}