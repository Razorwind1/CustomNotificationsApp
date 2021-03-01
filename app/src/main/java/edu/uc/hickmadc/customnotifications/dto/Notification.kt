package edu.uc.hickmadc.customnotifications.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

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
    var title: String = "",
    var subtext: String = "",
    var desc: String = "",
    @PrimaryKey @SerializedName("id") var notification_id: Int = 0
) {
    override fun toString(): String {
        return "$title $subtext"
    }
}