package edu.uc.hickmadc.customnotifications.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import edu.uc.hickmadc.customnotifications.dto.Group

@Dao
interface iGroupDAO {

    @Query("SELECT * FROM `group`")
    fun getAllGroups() : LiveData<List<Group>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(group: ArrayList<Group>)

    @Delete
    fun delete(group: Group)

    @Insert
    fun save(group: Group)

}