package edu.uc.hickmadc.customnotifications.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * The Alarm DTO.
 *
 * Stores the title, name and status of a alarm.
 * @param name the displayed name of the alarm
 * @param desc the description of the alarm
 * @param active if the alarm is in effect or not
 */
@Entity(tableName = "alarm")
data class Alarm(
    @ColumnInfo(name = "name")
    var name: String = "",

    @ColumnInfo(name = "desc")
    var desc: String = "",

    @ColumnInfo(name = "active")
    var active: Boolean = false,

    @PrimaryKey(autoGenerate = true)
    var alarmid: Int = 0
) {
    override fun toString(): String {
        return "$name $desc"
    }
}