package edu.uc.hickmadc.customnotifications.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "group")
data class Group (var name : String, var desc : String, var active : Boolean, var same_schedule : Boolean, @PrimaryKey @SerializedName("id") var group_id:Int=0) {
    override fun toString(): String {
        return "$name $desc"
    }
}