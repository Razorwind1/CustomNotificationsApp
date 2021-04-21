package edu.uc.hickmadc.customnotifications.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * The Notification DTO.
 *
 * Stores the title, subtext, and description of a notification.
 * @param title the displayed title of the notification
 * @param subtext the displayed subtext of the notification
 * @param desc the description of the notification
 * @param date the date to trigger
 * @param nextDate the next occurrence date
 * @param time the time to trigger
 * @param interval the repeat interval
 */
@Entity(tableName = "notification")
data class Notification(
    @ColumnInfo(name = "title")
    var title: String = "",

    @ColumnInfo(name = "subtext")
    var subtext: String = "",

    @ColumnInfo(name = "description")
    var desc: String = "",

    @ColumnInfo(name = "date")
    var date: String = "",

    @ColumnInfo(name = "nextDate")
    var nextDate: String = "",

    @ColumnInfo(name = "time")
    var time: String = "",

    @ColumnInfo(name = "interval")
    var interval: String = "",

    @PrimaryKey(autoGenerate = true)
    var notificationId: Int = 0
) {
    override fun toString(): String {
        return "$title $subtext"
    }
}