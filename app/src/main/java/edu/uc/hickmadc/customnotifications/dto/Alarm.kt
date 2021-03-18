package edu.uc.hickmadc.customnotifications.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "alarm")
data class Alarm (var name : String, var desc : String, var active : Boolean, var random : Boolean, @PrimaryKey @SerializedName("id") var alarm_id:Int=0) {
    override fun toString(): String {
        return "$name $desc"
    }
}