package edu.uc.hickmadc.customnotifications.dto

import androidx.room.*

/**
 * The Notification DTO.
 *
 * Stores the title, subtext, and description of a notification.
 * @param title the displayed title of the notification
 * @param subtext the displayed subtext of the notification
 * @param desc the description of the notification
 */
@Entity(tableName = "notification")
data class Notification(
    @ColumnInfo(name = "title")
    var title: String = "",

    @ColumnInfo(name = "subtext")
    var subtext: String = "",

    @ColumnInfo(name = "description")
    var desc: String = "",

    @PrimaryKey
    var notificationId: Int = 0
) {
    override fun toString(): String {
        return "$title $subtext"
    }
}